package hardwarestore.cart;

import hardwarestore.common.MinimalProduct;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
public class CartItem extends MinimalProduct {
    @Min(value = 1)
    private Integer quantity = 1;

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer amount) {
        this.quantity = amount;
    }
}
