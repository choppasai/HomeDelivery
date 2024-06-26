package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Products;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import HomeDelivery.Ecommerce.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;

    }
    @GetMapping("/{id}")
    public @ResponseBody ProductDTO getProductById(
            @PathVariable("id") int id) throws Exception {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    //    @RequestBody Product product -> Converts the received json to a Product java object
    @PostMapping("")

    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/productsCategory/{categoryName}")
    public ResponseEntity<List<ProductDTO>> productsByCategory(@PathVariable String categoryName){
        return ResponseEntity.ok(productService.getByCategory(categoryName));
    }

}