package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.ProductRepository;
import com.klaster.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by MSI DRAGON on 2017-09-09.
 */
@Service("ProductService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("ProductRepository")
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void create(Product product){
        productRepository.create(product);
    }
    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    @Transactional
    public Product read(long productId) {
        return productRepository.read(productId);
    }

    @Override
    @Transactional
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    @Transactional
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Transactional
    public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    @Transactional
    public Set<Product> getProductByCategoryPriceManufacturer(String productCategory, int low, int high, String manufacturer) {
        return productRepository.getProductByCategoryPriceManufacturer(productCategory, low, high, manufacturer);
    }
}
