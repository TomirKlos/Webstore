package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.Customer;
import com.klaster.webstore.domain.repository.CustomerRepository;
import com.klaster.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("CustomerRepository")
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public void create(Customer customer){
        customerRepository.create(customer);
    }
    @Override
    @Transactional
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    @Transactional
    public Customer read(long customerId) {
        return customerRepository.read(customerId);
    }

    @Override
    @Transactional
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

}
