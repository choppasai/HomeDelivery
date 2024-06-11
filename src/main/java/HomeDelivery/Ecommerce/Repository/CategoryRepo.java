package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, String> {

    public Category findByCategoryName(String category);
}
