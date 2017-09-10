package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.ProductRepository;
import com.klaster.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    @Qualifier("ProductRepository")
    private ProductRepository productRepository;

    @Override
    @Transactional
    public void processOrder(long productId, int count) {
        Product productById = productRepository.read(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie: " + productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }
}
