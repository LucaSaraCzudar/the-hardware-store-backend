package com.eureka.cart.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartItemTest {

    CartItem cartItem;

    @BeforeEach
    void setUp() {
        cartItem = new CartItem();
    }

    @Test
    void getQuantity() {
        assertEquals(cartItem.getQuantity(), 1);
    }

    @Test
    void setQuantity() {
        cartItem.setQuantity(5);
        assertEquals(cartItem.getQuantity(), 5);
    }
}
