package com.eureka.cart.controllers;

import com.eureka.cart.models.CartItem;
import com.eureka.cart.exceptions.CartItemNotFoundException;
import com.eureka.cart.repository.CartItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CartController {

    private final CartItemRepository repository;

    CartController(CartItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    List<CartItem> getAllCartItems() {
        return repository.findAll();
    }

    @PostMapping("/")
    CartItem addCartItem(@RequestBody CartItem cartItem) {
        return repository.save(cartItem);
    }

    @GetMapping("/{id}")
    CartItem getCartItem(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new CartItemNotFoundException(id));
    }

    @PutMapping("/{id}")
    CartItem updateCartItem(@RequestBody Integer quantity, @PathVariable String id) {

        return repository.findById(id)
                .map(item -> {
                    item.setQuantity(quantity);
                    return repository.save(item);
                })
                .orElseThrow(() -> new CartItemNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteCartItem(@PathVariable String id) {
        repository.deleteById(id);
    }
}
