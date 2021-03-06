package com.klaster.webstore.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by MSI DRAGON on 2017-09-08.
 */
@Entity
public class Product implements Serializable{
    @Transient
    private static final long serialVersionUID = -981621208366571343L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    @Size(min=3, max=50, message="{Size.Product.name.validation}")
    private String name;
    @Min(value=0, message="{Min.Product.unitPrice.validation}")
    @Digits(integer=8, fraction=2, message="{Digits.Product.unitPrice.validation}")
    @NotNull(message= "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    @Min(value=1, message="{Min.Product.unitsInStock.validation}")
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String conditionProduct;
    @Transient
    private MultipartFile productImage;



    public Product() {
        super();
    }
    public Product(long productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }
    public Product(String name) {
        this.name = name;
    }

    public Product(String name, BigDecimal unitPrice, String description, String manufacturer, String category, long unitsInStock, long unitsInOrder, boolean discontinued, String conditionProduct) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.description = description;
        this.manufacturer = manufacturer;
        this.category = category;
        this.unitsInStock = unitsInStock;
        this.unitsInOrder = unitsInOrder;
        this.discontinued = discontinued;
        this.conditionProduct = conditionProduct;
    }


    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public boolean isDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public String getConditionProduct() {
        return conditionProduct;
    }

    public void setConditionProduct(String conditionProduct) {
        this.conditionProduct = conditionProduct;
    }
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductId() != product.getProductId()) return false;
        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        int result = (int) (getProductId() ^ (getProductId() >>> 32));
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Produkt [productId=" + productId + ", nazwa=" + name +"]";
    }
}

