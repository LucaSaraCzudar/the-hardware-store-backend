package com.cart.controllers;

import com.cart.exceptions.CartItemNotFoundException;
import com.cart.models.CartItem;
import com.cart.repository.CartItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    private final CartItemRepository repository;

    CartController(CartItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cart-items")
    List<CartItem> getAllCartItems() {
        return repository.findAll();
    }

    @PostMapping("/cart-items")
    CartItem addCartItem(@RequestBody CartItem cartItem) {
        return repository.save(cartItem);
    }

    @GetMapping("/cart-items/{id}")
    CartItem getCartItem(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new CartItemNotFoundException(id));
    }

    @PutMapping("/cart-items/{id}")
    CartItem updateCartItem(@RequestBody Integer quantity, @PathVariable String id) {

        return repository.findById(id)
                .map(item -> {
                    item.setQuantity(quantity);
                    return repository.save(item);
                })
                .orElseThrow(() -> new CartItemNotFoundException(id));
    }

    @DeleteMapping("/cart-items/{id}")
    void deleteCartItem(@PathVariable String id) {
        repository.deleteById(id);
    }
}
