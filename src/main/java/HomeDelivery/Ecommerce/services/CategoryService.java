package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.CategoryRepo;
import HomeDelivery.Ecommerce.models.Category;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    public void createCategory(String name){
        Category category = new Category();
        category.setCategoryName(name);
        categoryRepo.save(category);
    }
}
