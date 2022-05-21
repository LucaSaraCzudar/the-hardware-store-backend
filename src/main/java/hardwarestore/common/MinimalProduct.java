package hardwarestore.common;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
public abstract class MinimalProduct {
    protected @Id String id;
    protected String name;
    protected Float price;

    public MinimalProduct() {}

    public MinimalProduct(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof MinimalProduct MinimalProduct))
            return false;
        return Objects.equals(this.id, MinimalProduct.id) && Objects.equals(this.name, MinimalProduct.name)
                && Objects.equals(this.price, MinimalProduct.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.price);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + this.id + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + '}';
    }
}
