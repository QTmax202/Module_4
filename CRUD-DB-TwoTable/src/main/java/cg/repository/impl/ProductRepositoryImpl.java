package cg.repository.impl;

import cg.model.Product;
import cg.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ArrayList<Product> findAll() {
        String queryStr = "SELECT p FROM Product AS p";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        return (ArrayList<Product>) query.getResultList();
    }

    @Override
    public Product save(Product product) {
        if (product.getId() != 0) {
            //update
            return entityManager.merge(product);
        } else {
            //create
            entityManager.persist(product);
            return product;
        }
    }

    @Override
    public Product delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
        return product;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }
}
