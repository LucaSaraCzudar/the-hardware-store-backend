package hardwarestore.product;

import hardwarestore.common.MinimalProduct;

import javax.persistence.Entity;

@Entity
public class Product extends MinimalProduct {

    private ProductType productType;
    private String description;
    private String imageBase64;

    public Product() {}

    public Product(String name, Float price, ProductType productType, String description, String imageBase64) {
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