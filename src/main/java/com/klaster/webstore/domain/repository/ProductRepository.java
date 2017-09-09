package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Product;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-09.
 */
public interface ProductRepository {

    List<Product> getAllProducts();
}
