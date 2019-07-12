package pl.coderslab.repository;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List showCategory() {
        Query query = entityManager.createQuery("SELECT category FROM Category category");
        //dodać możliwość przejścia do listy wszystkich artykułów z danej kategorii.
        return query.getResultList();
    }

    public void saveCategory(Category category) {
        entityManager.persist(category);
    }

    public Category findOneById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

    public void deleteCategory(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public List findCategoriesFetchArticles() {
        Query query = entityManager.createQuery("SELECT category FROM Category category");
        List<Category> resultList = query.getResultList();

        for (Category category : resultList) {
            Hibernate.initialize(category.getArticles());
        }

        return resultList;
    }
}