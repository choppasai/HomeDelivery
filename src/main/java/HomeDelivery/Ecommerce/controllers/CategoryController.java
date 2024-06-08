package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.CategoryDTO;
import HomeDelivery.Ecommerce.services.CategoryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO.getCategoryName());
        return new ResponseEntity<String>("created",HttpStatusCode.valueOf(200));

    }

}
