package com.klaster.webstore.exception;

/**
 * Created by MSI DRAGON on 2017-09-28.
 */
public class InvalidCartException extends RuntimeException {

    private static final long serialVersionUID = 232803477792880418L;
    private String cartId;
    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }
    public String getCartId() {
        return cartId;
    }
}
