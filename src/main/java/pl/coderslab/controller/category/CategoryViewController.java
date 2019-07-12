package pl.coderslab.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryViewController {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryViewController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public String showCategory(Model model) {
        List list = categoryDao.showCategory();
        model.addAttribute("category", list);
        return "display_categories";
    }

    @GetMapping("/add")
    public String createCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping("/added")
    public String createCategory(Category category, Model model) {
        categoryDao.saveCategory(category);
        List list = categoryDao.showCategory();
        model.addAttribute("category", list);
        return "display_categories";
    }

    @GetMapping("/delete")
    public String deleteCategory(Model model,
                                 @RequestParam Long id) {
        categoryDao.deleteCategory(categoryDao.findOneById(id));
        List list = categoryDao.showCategory();
        model.addAttribute("category", list);
        return "display_categories";
    }

    @PostMapping("/edit")
    public String editCategory(Model model,
                               @RequestParam Long id) {
        model.addAttribute("category", categoryDao.findOneById(id));
        return "edit_category";
    }

    @PostMapping("/edited")
    public String editedCategory(Category category, Model model) {
        Category oneById = categoryDao.findOneById(category.getId());
        oneById.setDescription(category.getDescription());
        oneById.setName(category.getName());
        categoryDao.updateCategory(oneById);
        List list = categoryDao.showCategory();
        model.addAttribute("category", list);
        return "display_categories";
    }

}

