package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {
    @Override
    public Page<Products> findAll(Pageable pageable);
    @Query("select p from Products p where p.price between :min and :max")
    public List<Products> findPriceInRange(@Param("min") int min, @Param("max") int max);
    @Query("select p from Products p where p.price between :min and :max order by p.price")
    public Slice<Products> findPriceInRangeSlice(@Param("min") int min, @Param("max") int max);
    @Query("select p from Products p where p.category.categoryID = (select c.categoryID from Category c where c.categoryName= :categoryName)")
    public List<Products> findByCategoryName(@Param("categoryName") String categoryName);
}
