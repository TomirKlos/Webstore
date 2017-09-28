package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Order;

/**
 * Created by MSI DRAGON on 2017-09-28.
 */
public interface OrderRepository {
    Long saveOrder(Order order);
}
