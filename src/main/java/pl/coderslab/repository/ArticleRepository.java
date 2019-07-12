package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Article;
@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Long> {






}
