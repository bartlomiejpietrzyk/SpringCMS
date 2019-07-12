package pl.coderslab.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.dto.ArticleDto;
import pl.coderslab.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ArticleDao {


    @PersistenceContext
    private EntityManager entityManager;

    public List showArticlesWithValue(int value) {
        Query queryp = entityManager.createQuery("SELECT article from Article article ");
        queryp.setMaxResults(value);
        List<Article> resultList = queryp.getResultList();

        List<ArticleDto> resultListDto = resultList
                .stream()
                .map(ArticleDto::new)//map zamienia obiekt na obiekt
                .peek(articleDto -> articleDto.shortenContent(200)) //peek służy do wyświetlenia, bo ma void. Peek puszcze dalej to co wywoła
                .collect(Collectors.toList());

        return resultListDto;

    }

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void fetchAuthor(Article article) {
        entityManager.merge(article);
        Hibernate.initialize(article.getAuthor());
    }

    public List showAllArticle() {
        Query query = entityManager.createQuery("SELECT article from Article article ");
        List<Article> all = query.getResultList();
        return all
                .stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public Article findOneById(Long id) {
        return entityManager.find(Article.class, id);
    }


}