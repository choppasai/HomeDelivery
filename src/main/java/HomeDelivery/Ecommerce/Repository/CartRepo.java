package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
}
