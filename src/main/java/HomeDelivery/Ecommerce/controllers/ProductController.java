package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.ProductModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import HomeDelivery.Ecommerce.services.ProductService;

import java.net.URI;
import java.net.URISyntaxException;
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
            @PathVariable("id") Long id) throws Exception {
        return productService.getProductById(id);
    }

    @GetMapping("")
    public @ResponseBody List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    //    @RequestBody Product product -> Converts the received json to a Product java object
    @PostMapping("")
    public String createProduct(@RequestBody ProductModel productModel) {
        System.out.println(productModel.getCategory());
        System.out.println(productModel.getTitle());
        System.out.println(productModel.getPrice());
        return "Product created.";
    }




}