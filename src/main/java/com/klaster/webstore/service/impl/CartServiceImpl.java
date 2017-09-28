package com.klaster.webstore.service.impl;

import com.klaster.webstore.domain.Cart;
import com.klaster.webstore.domain.repository.CartRepository;
import com.klaster.webstore.exception.InvalidCartException;
import com.klaster.webstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    @Qualifier("CartRepository")
    private CartRepository cartRepository;
    public Cart create(Cart cart) {
        return cartRepository.create(cart);
    }
    public Cart read(String cartId) {
        return cartRepository.read(cartId);
    }
    public void update(String cartId, Cart cart) {
        cartRepository.update(cartId, cart);
    }
    public void delete(String cartId) {
        cartRepository.delete(cartId);
    }

    public Cart validate(String cartId) {
        Cart cart = cartRepository.read(cartId);
        if(cart==null || cart.getCartItems().size()==0) {
            throw new InvalidCartException(cartId);
        }
        return cart;
    }
}