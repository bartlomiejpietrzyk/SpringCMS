package pl.coderslab.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.ArticleDto;
import pl.coderslab.model.Article;
import pl.coderslab.repository.ArticleDao;
import pl.coderslab.repository.AuthorDao;
import pl.coderslab.repository.CategoryDao;
import pl.coderslab.service.ArticleService;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleViewController {
    private ArticleService articleService;
    private CategoryService categoryService;
    private AuthorService authorService;

    @Autowired
    public ArticleViewController(ArticleService articleService, CategoryService categoryService, AuthorService authorService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping
    public String showArticles(Model model) {
        model.addAttribute("article", articleService.findAll());
        return "display_articles";
    }

    @ModelAttribute("categories")
    public List getAllCategories() {
        return categoryService.findAll();    }

    @ModelAttribute("authors")
    public List getAllAuthors()
    {
        return authorService.findAll();
    }

    @GetMapping("/add")
    public String createArticleView(Model model) {
        model.addAttribute("article", new ArticleDto());
        return "create_article";
    }

    @PostMapping("/add")
    public String createArticle(ArticleDto articleDto,
                                @ModelAttribute("article") @Valid Article article,
                                BindingResult result) {
        if(result.hasErrors()) {
            return "/articles/add";
        }
        articleService.createArticle(articleDto);

        return "redirect:/articles";
    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam Long id) {
        articleService.delete(articleService.findOne(id));

        return "redirect:/articles";
    }

    @GetMapping("/edit")
    public String editArticleView(Model model,
                                  @RequestParam Long id) {
        model.addAttribute("article", articleService.findOneDto(id));
        return "edit_article";
    }

    @PostMapping("/edited")
    public String editArticle(ArticleDto articleDto,
                              @ModelAttribute("article")
                              @Valid Article article) {
        articleService.editArticle(articleDto);

        return "redirect:/articles";

    }
}