package hardwarestore.cart.repository;

import hardwarestore.cart.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, String> {}
