package com.klaster.webstore.domain.repository.impl;

import com.klaster.webstore.domain.ProductPicture;
import com.klaster.webstore.domain.repository.ProductPictureRepository;
import com.klaster.webstore.exception.ProductNotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
@Repository("ProductPictureRepository")
public class ProductPictureRepositoryImpl implements ProductPictureRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(ProductPicture productPicture){
        sessionFactory.getCurrentSession().saveOrUpdate(productPicture);
    }

    @Override
    public ProductPicture read(long productId){
        //  return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
        ProductPicture productPicture = sessionFactory.getCurrentSession().get(ProductPicture.class, productId);
        if(productPicture==null) throw new ProductNotFoundException(productId);
        else return productPicture;
    }

    @Override
    public void delete(ProductPicture productPicture) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM product_pictures WHERE productId = "+productPicture.getProductId()).executeUpdate();
    }
}
