package com.klaster.webstore.domain.repository.impl;

import com.klaster.webstore.domain.Product;
import com.klaster.webstore.domain.ProductThumbnail;
import com.klaster.webstore.domain.repository.ProductThumbnailRepository;
import com.klaster.webstore.exception.ProductNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
@Repository("ProductThumbnailRepository")
public class ProductThumbnailRepositoryImpl implements ProductThumbnailRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(ProductThumbnail productThumbnail){
        sessionFactory.getCurrentSession().saveOrUpdate(productThumbnail);
    }

    @Override
    public ProductThumbnail read(long productId){
        //  return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
        ProductThumbnail productThumbnail = sessionFactory.getCurrentSession().get(ProductThumbnail.class, productId);
        if(productThumbnail==null) throw new ProductNotFoundException(productId);
        else return productThumbnail;
    }

    @Override
    public void delete(ProductThumbnail productThumbnail) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM productThumbnail WHERE productId = "+productThumbnail.getProductId()).executeUpdate();
    }
}
