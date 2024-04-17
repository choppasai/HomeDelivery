package HomeDelivery.Ecommerce.controllers;

import Exceptions.NotFoundException;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
//    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{id}")
    public @ResponseBody ProductDTO getProductById(@PathVariable int id) throws NotFoundException {

        return productService.getDetailsById(id);
    }
    @GetMapping("")
    public @ResponseBody List<ProductDTO> getAllProducts(){
        return  productService.getProducts();
    }
}
