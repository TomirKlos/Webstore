package com.klaster.webstore.service;

import com.klaster.webstore.domain.Order;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
public interface OrderService {
    void processOrder(long productId, int count);
    Long saveOrder(Order order);
}
