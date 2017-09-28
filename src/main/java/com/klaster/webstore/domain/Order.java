package com.klaster.webstore.domain;

import java.io.Serializable;

/**
 * Created by MSI DRAGON on 2017-09-28.
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -9125539524545107952L;
    private Long orderId;
    private Cart cart;
    private Customer customer;
    private ShippingDetail shippingDetail;
    public Order() {
        this.customer = new Customer();
        this.shippingDetail = new ShippingDetail();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return getOrderId().equals(order.getOrderId());
    }

    @Override
    public int hashCode() {
        return getOrderId().hashCode();
    }
}
