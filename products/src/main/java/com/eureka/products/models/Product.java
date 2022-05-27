package com.eureka.products.models;

import com.eureka.products.models.MinimalProduct;
import com.eureka.products.enums.ProductType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Entity
public class Product extends MinimalProduct {
    private ProductType productType;
    @Column(length=1000)
    private String description;
    @Column(length=100000)
    private String imageBase64;

    public Product() {}

    public Product(String name, Float price, ProductType productType, String description, String imageBase64) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.description = description;
        this.imageBase64 = imageBase64;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageBase64() {
        return this.imageBase64;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
}
