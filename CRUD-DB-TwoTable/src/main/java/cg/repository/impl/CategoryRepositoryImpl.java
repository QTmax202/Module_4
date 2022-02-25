package cg.repository.impl;

import cg.model.Category;
import cg.model.Product;
import cg.repository.ICategoryRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<Category> findAll() {
        String queryStr = "SELECT c FROM Category AS c";
        TypedQuery<Category> query = entityManager.createQuery(queryStr, Category.class);
        return (ArrayList<Category>) query.getResultList();
    }

    @Override
    public Category save(Category category) {
        if (category.getC_id() != 0) {
            //update
            return entityManager.merge(category);
        } else {
            //create
            entityManager.persist(category);
            return category;
        }
    }

    @Override
    public Category delete(int id) {
        Category category = findById(id);
        entityManager.remove(category);
        return category;
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }
}
