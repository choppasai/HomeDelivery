package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Integer> {
}
