package com.klaster.webstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by MSI DRAGON on 2017-09-10.
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    private String name;
    private String address;
    private String phoneNumber;

    private int noOfOrdersMade;

    public Customer(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return getCustomerId() == customer.getCustomerId();
    }

    @Override
    public int hashCode() {
        return (int) (getCustomerId() ^ (getCustomerId() >>> 32));
    }
}
