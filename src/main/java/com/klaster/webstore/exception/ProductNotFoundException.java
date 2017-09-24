package com.klaster.webstore.exception;

import java.io.Serializable;

/**
 * Created by MSI DRAGON on 2017-09-24.
 */
public class ProductNotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -998080770802646341L;
    private long productId;
    public ProductNotFoundException(long productId) {
        this.productId = productId;
    }
    public long getProductId() {
        return productId;
    }
}
