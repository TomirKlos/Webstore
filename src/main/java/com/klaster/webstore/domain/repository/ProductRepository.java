package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
    List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
    Set<Product> getProductByCategoryPriceManufacturer(String productCategory, int low, int high, String manufacturer);

}
