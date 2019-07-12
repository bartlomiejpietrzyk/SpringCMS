package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.repository.ArticleDao;

import java.util.List;

@Controller
public class HomePageController {

    private ArticleDao articleDao;

    @Autowired
    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping("/lastArticles/{val}")
    @ResponseBody
    public List showLastArticlesWithVal(@PathVariable int val) {
        return articleDao.showArticlesWithValue(val);
    }
}