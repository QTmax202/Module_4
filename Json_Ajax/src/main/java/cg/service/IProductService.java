package cg.service;

import cg.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findProductByNameContaining(String name);

    Page<Product> findAllByCategory(Long id, Pageable pageable);
}
