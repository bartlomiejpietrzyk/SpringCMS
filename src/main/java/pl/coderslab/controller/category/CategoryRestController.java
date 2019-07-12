package pl.coderslab.controller.category;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.repository.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryRestController {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryRestController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public List showCategories() {
        List category = categoryDao.showCategory();
        Hibernate.initialize(category);
        return category;
    }
}