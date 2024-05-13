package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,Long> {
}
