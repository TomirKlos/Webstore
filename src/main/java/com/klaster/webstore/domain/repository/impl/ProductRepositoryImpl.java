package com.klaster.webstore.domain.repository.impl;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.repository.ProductRepository;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-09.
 */
@Repository("ProductRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Product product){
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public Product read(long productId){
        //  return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
        Product product = sessionFactory.getCurrentSession().get(Product.class, productId);
        if(product==null) throw new IllegalArgumentException("Brak produktu o wskazanym id: "+ productId);
        else return product;
    }

    @Override
    public void delete(Product product) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM products WHERE productId = "+product.getProductId()).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> getAllProducts() {
        return (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        // Create CriteriaBuilder
    //    CriteriaQuery<Product> cq = sessionFactory.getCriteriaBuilder().createQuery(Product.class);
      //  cq.from(Product.class);
     //  return (List<Product>) sessionFactory.createEntityManager(cq).getResultList();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Product> getProductsByCategory(String category){
        //ArrayList<Product> product = sessionFactory.getCurrentSession().get(Product.class, category);
       // List<Product> product = (List<Product>) sessionFactory.getCurrentSession().c;
       // if(product.isEmpty()) throw new IllegalArgumentException("Brak produktów we wskazanej kategorii: "+ category);
       // else return product;
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(Product.class);
        crit.add(Restrictions.like("category", category));
        List<Product> product = crit.list();
        return product;

    }


    //TODO Dodac implementacje UPDATE
}

