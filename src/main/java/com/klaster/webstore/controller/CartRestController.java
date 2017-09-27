package com.klaster.webstore.controller;

import com.klaster.webstore.domain.Cart;
import com.klaster.webstore.domain.CartItem;
import com.klaster.webstore.domain.Product;
import com.klaster.webstore.exception.ProductNotFoundException;
import com.klaster.webstore.service.CartService;
import com.klaster.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
@Controller
@RequestMapping(value = "rest/cart")
public class CartRestController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }
    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") String cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }
    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }
    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable long productId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if(cart== null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.read(productId);
        if(product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }
        cart.addCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }
    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable long productId, HttpServletRequest request) {
        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if(cart== null) {
            cart = cartService.create(new Cart(sessionId));
        }
        Product product = productService.read(productId);
        if(product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId));
        }
        cart.removeCartItem(new CartItem(product));
        cartService.update(sessionId, cart);
    }
    //@ExceptionHandler(IllegalArgumentException.class)
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Niepoprawne żądanie, sprawdź przesyłane dane.")
       //     public void handleClientErrors(Exception ex) { }
  //  @ExceptionHandler(Exception.class)
   // @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Wewnętrzny błąd serwera.")
       //     public void handleServerErrors(Exception ex) { }
}
