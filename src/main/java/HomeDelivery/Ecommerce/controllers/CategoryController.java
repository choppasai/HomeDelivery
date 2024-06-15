package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.CategoryDTO;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Category;
import HomeDelivery.Ecommerce.models.Products;
import HomeDelivery.Ecommerce.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO.getCategoryName());
        return new ResponseEntity<String>("created",HttpStatusCode.valueOf(200));

    }
    @GetMapping("/{id}")
    public List<ProductDTO> getByCategoryId(@PathVariable int id) throws Exception {
         Category category = categoryService.getCategory(id);
         List<ProductDTO> productDTOList = new ArrayList<>();
         for(Products product:category.getProducts()){
             ProductDTO productDTO = new ProductDTO();
             modelMapper.map(product,productDTO);
             productDTOList.add(productDTO);
         }
         return productDTOList;
    }
    @PostMapping("/products/titles")
        public List<String> listOfCategoryTitle(@RequestBody CategoryTitleDTO categoryTitleDTO){
            List<Integer> integerList = categoryTitleDTO.getId();
        return categoryService.getAllTitlesOfCategory(integerList);
    }
}
