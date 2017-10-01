package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.ProductThumbnail;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */
public interface ProductThumbnailRepository {
    void create(ProductThumbnail productThumbnail);
    ProductThumbnail read(long productId);
    void delete(ProductThumbnail productThumbnail);
}
