package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Exceptions.NotFoundException;
import HomeDelivery.Ecommerce.Repository.CategoryRepo;
import HomeDelivery.Ecommerce.Repository.ProductRepo;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Category;
import HomeDelivery.Ecommerce.models.Products;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    final private ModelMapper modelMapper;
    final private ProductRepo productRepo;
    final private CategoryRepo categoryRepo;

    public ProductService(ModelMapper modelMapper, ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.modelMapper = modelMapper;
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    // Call the DB
    // Call the Fake Store API.
    // https://fakestoreapi.com/products/15
    public ProductDTO getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" + id;
        Products productModel = restTemplate.getForObject(url, Products.class);

        System.out.println(productModel);

        if (productModel == null) {
            throw new NotFoundException();
        }
        return convertToDto(productModel);

    }
    public void createProduct(ProductDTO productDTO){
        Products products = new Products();
        products.setTitle(productDTO.getTitle());
        products.setPrice(productDTO.getPrice());
        products.setSeller(productDTO.getSeller());
        Category category = new Category();
        category.setCategoryName(productDTO.getCategory());
        products.setCategory(category);
        categoryRepo.save(category);
        productRepo.save(products);
    }

    private static ProductDTO convertToDto(Products productModel) {
        ProductDTO obj =  new ProductDTO();
        obj.setTitle(productModel.getTitle());
        obj.setPrice(productModel.getPrice());
        return obj;
    }


    public List<ProductDTO> getAllProducts() {
        // 1. Make a call to 3p api.
        // 2. Deserialize into Java object -> Array of products
        // 3. Convert the array into array/list of dto objects.
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/";
        Products[] products = restTemplate.getForObject(url, Products[].class);

        List<ProductDTO> returnedProducts = new ArrayList<>();

        assert products != null;
        for (Products product: products) {
            returnedProducts.add(convertToDto(product));
        }
        return returnedProducts;
    }
}