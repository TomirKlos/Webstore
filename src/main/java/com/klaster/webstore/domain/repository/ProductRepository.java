package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Product;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-09.
 */
public interface ProductRepository {
    void create(Product product);
    Product read(long productId);
  //  Product update(Product product);
    void delete(Product product);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
