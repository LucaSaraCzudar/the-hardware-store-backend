package com.eureka.cart.exceptions;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String id) {
        super("Could not find product " + id);
    }
}
