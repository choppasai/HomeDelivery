package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface CartRepo extends JpaRepository<Cart, Integer> {
}
