package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryDao;

public class CategoryConverter implements Converter<String, Category> {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryConverter(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category convert(String s) {
        return categoryDao.findOneById(Long.parseLong(s));
    }
}
