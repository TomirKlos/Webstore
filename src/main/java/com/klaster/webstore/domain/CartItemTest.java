package com.klaster.webstore.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI DRAGON on 2017-09-27.
 */
public class CartItemTest {
    private CartItem cartItem;
    @Before
    public void setup() {
        cartItem = new CartItem();

    }
    @Test
    public void cartItem_total_price_should_be_eaual_to_product_unit_price_in_case_of_single_quantity() {
        // Ustaw.
        Product iphone = new Product(123,"iPhone 5s", new BigDecimal(500));
        cartItem.setProduct(iphone);
        // Wykonaj.
        BigDecimal totalPrice = cartItem.getTotalPrice();
        // Porównaj.
        Assert.assertEquals(iphone.getUnitPrice(), totalPrice);
    }

    @Test
    public void cartItem_total_price_should_be_equal_to_grand_total_price_of_products_in_cart(){
        Product iApple = new Product(123,"Iapple", new BigDecimal(200));
        Product iphone = new Product(133,"iPhone 5s", new BigDecimal(500));
        Product laptop = new Product(144,"dell", new BigDecimal(1000));

        List<Product> list = new ArrayList<Product>();
        list.add(iApple);
        list.add(iphone);
        list.add(laptop);

        Cart cart = new Cart();
        cart.addCartItem(cartItem.getCartItem(iApple));
        cart.addCartItem(cartItem.getCartItem(iphone));
        cart.addCartItem(cartItem.getCartItem(laptop));

        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for(Product product : list) {
            totalPrice = totalPrice.add(cartItem.getCartItem(product).getTotalPrice());
        }

        Assert.assertEquals(cart.getGrandTotal(), totalPrice);

    }
}