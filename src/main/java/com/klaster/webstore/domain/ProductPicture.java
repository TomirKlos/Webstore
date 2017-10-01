package com.klaster.webstore.domain;

import javax.persistence.*;

/**
 * Created by MSI DRAGON on 2017-10-01.
 */

@Entity
@Table(name = "product_pictures")
public class ProductPicture {
    @Id
    private long productId;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String base64Image;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;

    public ProductPicture() {
        super();
    }

    public ProductPicture(Product product) {
        this.product = product;
    }

    public ProductPicture(String base64Image, Product product) {
        this.base64Image = base64Image;
        this.product = product;
    }

    public ProductPicture(long productId, String base64Image, Product product) {
        this.productId = productId;
        this.base64Image = base64Image;
        this.product = product;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductPicture)) return false;

        ProductPicture that = (ProductPicture) o;

        if (getProductId() != that.getProductId()) return false;
        if (!getBase64Image().equals(that.getBase64Image())) return false;
        return getProduct().equals(that.getProduct());
    }

    @Override
    public int hashCode() {
        int result = (int) (getProductId() ^ (getProductId() >>> 32));
        result = 31 * result + getBase64Image().hashCode();
        result = 31 * result + getProduct().hashCode();
        return result;
    }
}
