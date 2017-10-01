package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.ProductPicture;
import com.klaster.webstore.domain.repository.ProductPictureRepository;
import com.klaster.webstore.service.ProductPictureService;
import com.klaster.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
@Service("ProductPictureService")
public class ProductPictureServiceImpl implements ProductPictureService{
    @Autowired
    @Qualifier("ProductPictureRepository")
    private ProductPictureRepository productPictureRepository;

    @Override
    @Transactional
    public void create(ProductPicture productPicture){productPictureRepository.create(productPicture);
    }

    @Override
    @Transactional
    public ProductPicture read(long productId) {
        return productPictureRepository.read(productId);
    }

    @Override
    @Transactional
    public void delete(ProductPicture productPicture) {
        productPictureRepository.delete(productPicture);
    }
}
