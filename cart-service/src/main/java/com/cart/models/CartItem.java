package com.cart.models;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
public class CartItem extends MinimalProduct {
    @Min(value = 1)
    private Integer quantity = 1;

    public CartItem(String id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public CartItem() {}

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer amount) {
        this.quantity = amount;
    }
}
