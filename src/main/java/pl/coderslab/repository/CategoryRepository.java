package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    <S extends Category> S save(S s);

    @Override
    Category findOne(Long aLong);

    @Override
    void delete(Long aLong);

    @Override
    void delete(Category category);


}
