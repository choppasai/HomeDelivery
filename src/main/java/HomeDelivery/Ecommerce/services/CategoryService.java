package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.CategoryRepo;
import HomeDelivery.Ecommerce.models.Category;
import org.springframework.stereotype.Service;

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
