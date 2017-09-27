package com.klaster.webstore.domain.repository;

import com.klaster.webstore.domain.Cart;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
public interface CartRepository {
    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

}
