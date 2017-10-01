package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.ProductPicture;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
public interface ProductPictureRepository {
    void create(ProductPicture productPicture);
    ProductPicture read(long productId);
    void delete(ProductPicture productPicture);
}
