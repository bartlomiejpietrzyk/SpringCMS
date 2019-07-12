package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dto.CategoryDto;
import pl.coderslab.model.Category;
import pl.coderslab.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryViewController {

    private CategoryService categoryService;

    @Autowired
    public CategoryViewController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "display_categories";
    }

    @GetMapping("/add")
    public String createCategoryView(Model model) {
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping("_after_add")
    public String createCategory(Category category, Model model) {
        categoryService.save(category);

        return "redirect:/categories";
    }


    @GetMapping("/delete")
    public String deleteCategory(Model model, @RequestParam long id) {
        categoryService.delete(categoryService.findOne(id));

        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String editCategoryView(Model model, @RequestParam long id) {
        model.addAttribute("category", categoryService.findOne(id));
        return "edit_category";
    }

    @PostMapping("/deleted")
    public String editCategory(CategoryDto categoryDto) {
        categoryService.edit(categoryDto);
        return "redirect:/categories";
    }
}