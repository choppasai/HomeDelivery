package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {


    Category findByCategoryName(String category);
    Optional<Category> findByCategoryID(Integer id);

}
