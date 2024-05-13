package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.GenericProducts;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface GenericRepo extends JpaRepository<GenericProducts,Integer> {
    @Query("select p from GenericProducts p where p.price between :min and :max")
    public abstract List<GenericProducts> findPriceInRange(@Param("min") int min, @Param("max") int max);
    @Query("select p from GenericProducts p where p.price between :min and :max order by p.price")
    public abstract Slice<GenericProducts> findPriceInRangeSlice(@Param("min") int min, @Param("max") int max);
}
