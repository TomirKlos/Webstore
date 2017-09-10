package com.klaster.webstore.domain.repository.impl;

import com.klaster.webstore.domain.Customer;
import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.CustomerRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Repository("CustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Customer customer){
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }

    @Override
    public Customer read(long customerId){
        //  return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
        Customer customer = sessionFactory.getCurrentSession().get(Customer.class, customerId);
        if(customer==null) throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ customerId);
        else return customer;
    }

    @Override
    public void delete(Customer customer) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM customers WHERE customerId= "+customer.getCustomerId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Customer> getAllCustomers() {
        return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
    }


    //TODO Dodac implementacje UPDATE

}
