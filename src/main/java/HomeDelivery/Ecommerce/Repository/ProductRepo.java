package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Products,Integer> {
//    @Query("select * from products p join category c on p.category_id = c.categoryID where c.categoryName=?1")
//    public List<Products> findByCategoryName(String categoryName);
}
