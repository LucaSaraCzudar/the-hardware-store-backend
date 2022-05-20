package hardwarestore.product;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Product {

    private @Id @GeneratedValue Long id;
    private String name;
    private Integer price;
    private ProductType productType;
    private String description;
    private String imageBase64;

    public Product() {}

    public Product(String name, Integer price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product Product))
            return false;
        return Objects.equals(this.id, Product.id) && Objects.equals(this.name, Product.name)
                && Objects.equals(this.productType, Product.productType) && Objects.equals(this.price, Product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.productType, this.price);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", productType='"
                 + this.productType + '\'' + ", price='" + this.price + '\'' + '}';
    }
}