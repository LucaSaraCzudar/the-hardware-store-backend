package hardwarestore.cart;

public class CartItemNotFoundException extends RuntimeException {
    CartItemNotFoundException(String id) {
        super("Could not find product " + id);
    }
}
