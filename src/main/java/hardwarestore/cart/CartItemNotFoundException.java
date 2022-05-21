package hardwarestore.cart;

public class CartItemNotFoundException extends RuntimeException {
    CartItemNotFoundException(Long id) {
        super("Could not find product " + id);
    }
}
