package HomeDelivery.Ecommerce.Repository;

import HomeDelivery.Ecommerce.models.Category;
import HomeDelivery.Ecommerce.models.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CategoryRepoTest {
    @Autowired
    private CategoryRepo categoryRepo;
    @Test
    @Transactional
        //@Rollback(value=false)
    void testLoading() {
        Category c = categoryRepo.findById(1).get();
        System.out.println(c.getCategoryName());
        List<Products> p = c.getProducts();
        for(Products product : p) {
            System.out.println(product.getTitle());
        }
    }


}