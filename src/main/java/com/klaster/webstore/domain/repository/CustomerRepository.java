package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Customer;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
public interface CustomerRepository {
    void create(Customer customer);
    Customer read(long productId);
    //  Product update(Customer customer);
    void delete(Customer customer);

    List<Customer> getAllCustomers();
}
