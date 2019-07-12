package pl.coderslab.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.ArticleDto;
import pl.coderslab.model.Article;
import pl.coderslab.repository.ArticleDao;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {
    private ArticleDao articleDao;

    @Autowired
    public ArticleRestController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public List showArticles() {
        List<Article> articles = articleDao.showAllArticle();

        return articles
                .stream()
                .map(ArticleDto::new)
                .collect(Collectors.toList());
    }
}
