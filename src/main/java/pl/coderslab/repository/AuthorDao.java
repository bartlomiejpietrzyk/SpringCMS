package pl.coderslab.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List showAuthors() {
        Query query = entityManager.createQuery("select author from Author author");
        return query.getResultList();
    }

    public List findAuthorsFetchArticles() {
        Query query = entityManager.createQuery("select author from Author author");
        List<Author> resultList = query.getResultList();
        for (Author author : resultList) {
            Hibernate.initialize(author.getArticles());
        }
        return resultList;
    }


    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author findOneById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void fetchArticles(Author author){
        entityManager.merge(author);
        Hibernate.initialize(author.getArticles());
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author) {
        entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
    }
}