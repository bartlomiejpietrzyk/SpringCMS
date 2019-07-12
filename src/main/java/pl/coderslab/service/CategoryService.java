package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dto.CategoryDto;
import pl.coderslab.model.Category;
import pl.coderslab.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList
                .stream()
                .map(CategoryDto::new)
                .collect(Collectors.toList());
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    public Category findOne(Long id) {
        return categoryRepository.findOne(id);
    }

    public void edit(CategoryDto categoryDto) {
        Category existing = categoryRepository.findOne(categoryDto.getId());

        existing.setDescription(categoryDto.getDescription());
        existing.setName(categoryDto.getName());

        categoryRepository.save(existing);
    }


}



