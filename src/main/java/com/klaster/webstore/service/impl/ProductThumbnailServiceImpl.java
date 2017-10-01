package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.ProductThumbnail;
import com.klaster.webstore.domain.repository.ProductThumbnailRepository;
import com.klaster.webstore.service.ProductThumbnailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
@Service("ProductThumbnailService")
public class ProductThumbnailServiceImpl implements ProductThumbnailService {
    @Autowired
    @Qualifier("ProductThumbnailRepository")
    private ProductThumbnailRepository productThumbnailRepository;


    @Override
    @Transactional
    public void create(ProductThumbnail productThumbnail){productThumbnailRepository.create(productThumbnail);
    }

    @Override
    @Transactional
    public ProductThumbnail read(long productId) {
        return productThumbnailRepository.read(productId);
    }

    @Override
    @Transactional
    public void delete(ProductThumbnail productThumbnail) {
        productThumbnailRepository.delete(productThumbnail);
    }

    @Override
    @Transactional
    public List<ProductThumbnail> getAllProducts() {
        return productThumbnailRepository.getAllProducts();
    }
}
