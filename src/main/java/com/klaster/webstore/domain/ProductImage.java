package com.klaster.webstore.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by MSI DRAGON on 2017-09-21.
 */
public class ProductImage {
    private MultipartFile productImage;


    public ProductImage() {
    }

    public ProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
