package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.CategoryRepo;
import HomeDelivery.Ecommerce.dto.CategoryDTO;
import HomeDelivery.Ecommerce.models.Category;
import HomeDelivery.Ecommerce.models.Products;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Transactional
    public Category getCategory(int id) throws Exception {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();

            List<Products> productsList =  category.getProducts();
            return category;
        }
        else{
            throw new Exception("category not found");
        }

    }
    public List<String> getAllTitlesOfCategory(List<Integer> ids){
        List<Category> categories = categoryRepo.findAllById(ids);
        List<String> titles = new ArrayList<>();
//       N+1  problems occurs here, so fetch type should  be join/subselect
        categories.forEach(category -> category.getProducts().
                forEach(products -> titles.add(products.getTitle())));
        return titles;
    }
}
