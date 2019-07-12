package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dto.ArticleDto;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;
import pl.coderslab.repository.ArticleRepository;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArticleService {

    private ArticleRepository articleRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ArticleDto> findAll() {
        List<Article> articleList = articleRepository.findAll();

        return articleList.stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public Article findOne(Long id) {
        return articleRepository.findOne(id);
    }

    public ArticleDto findOneDto(Long id) {
        ArticleDto articleDto = new ArticleDto(articleRepository.findOne(id));
        return articleDto;
    }

    public ArticleDto createArticle(ArticleDto articleDto) {

        Article article = new Article();
        article.setTitle(articleDto.getTitle());
        article.setContent(articleDto.getContent());
        article.setAuthor(authorRepository.findOne(articleDto.getAuthor()));

        article.getCategories().addAll(changeCategoryDTOtoCategory(articleDto.getCategories()));

        Article article1 = articleRepository.save(article);

        return new ArticleDto(article1);
    }

    public void editArticle(ArticleDto articleDto) {

        Article existing = articleRepository.findOne(articleDto.getId());

        existing.setContent(articleDto.getContent());
        existing.setAuthor(authorRepository.findOne(articleDto.getAuthor()));
        existing.getCategories().addAll(changeCategoryDTOtoCategory(articleDto.getCategories()));
        existing.setTitle(articleDto.getTitle());

        articleRepository.save(existing);

    }

    public Set<Category> changeCategoryDTOtoCategory (Long[] categories){
        List<Category> list = new ArrayList<>();

        for (Long along : categories) {
            list.add(categoryRepository.findOne(along));
        }
        return new HashSet<>(list);
    }

}