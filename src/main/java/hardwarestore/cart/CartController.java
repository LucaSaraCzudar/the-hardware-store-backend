package hardwarestore.cart;

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
    CartItem getCartItem(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CartItemNotFoundException(id));
    }

    @DeleteMapping("/cart-items/{id}")
    void deleteCartItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
