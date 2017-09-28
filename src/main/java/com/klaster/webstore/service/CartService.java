package com.klaster.webstore.service;

import com.klaster.webstore.domain.Cart;
import com.klaster.webstore.domain.repository.CartRepository;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
public interface CartService extends CartRepository {
    Cart validate(String cartId);
}
