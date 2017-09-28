package com.klaster.webstore.domain;

import java.io.Serializable;

/**
 * Created by MSI DRAGON on 2017-09-28.
 */
public class Address implements Serializable {
    private static final long serialVersionUID = 6320597398165503736L;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (getDoorNo() != null ? !getDoorNo().equals(address.getDoorNo()) : address.getDoorNo() != null) return false;
        if (getStreetName() != null ? !getStreetName().equals(address.getStreetName()) : address.getStreetName() != null)
            return false;
        if (getAreaName() != null ? !getAreaName().equals(address.getAreaName()) : address.getAreaName() != null)
            return false;
        if (getState() != null ? !getState().equals(address.getState()) : address.getState() != null) return false;
        if (getCountry() != null ? !getCountry().equals(address.getCountry()) : address.getCountry() != null)
            return false;
        return getZipCode() != null ? getZipCode().equals(address.getZipCode()) : address.getZipCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getDoorNo() != null ? getDoorNo().hashCode() : 0;
        result = 31 * result + (getStreetName() != null ? getStreetName().hashCode() : 0);
        result = 31 * result + (getAreaName() != null ? getAreaName().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getZipCode() != null ? getZipCode().hashCode() : 0);
        return result;
    }
}
