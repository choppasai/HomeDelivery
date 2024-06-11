package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Exceptions.NotFoundException;
import HomeDelivery.Ecommerce.Repository.CategoryRepo;
import HomeDelivery.Ecommerce.Repository.ProductRepo;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.Category;
import HomeDelivery.Ecommerce.models.Products;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    final private ProductRepo productRepo;
    final private CategoryRepo categoryRepo;


    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public ProductDTO getProductById(int id){
        Products products = CacheableById(id);
        return convertToDto(products);

    }
    @Cacheable(value = "product")
    public Products CacheableById(int id){
        return productRepo.getById(id);
    }

    @CachePut(value = "product",key = "#result.id")
    public Products createProduct(ProductDTO productDTO){
        Products products = new Products();
        products.setTitle(productDTO.getTitle());
        products.setPrice(productDTO.getPrice());
        products.setSeller(productDTO.getSeller());

        Category category = categoryRepo.findByCategoryName(productDTO.getCategory());
        if(category==null){
            Category category1 = new Category();
            category1.setCategoryName(productDTO.getCategory());
            products.setCategory(category1);
            categoryRepo.save(category1);
        }
        else
            products.setCategory(category);

        productRepo.save(products);
        return products;
    }

    private ProductDTO convertToDto(Products productModel) {
        ProductDTO obj =  new ProductDTO();
        obj.setTitle(productModel.getTitle());
        obj.setPrice(productModel.getPrice());
        return obj;
    }

//    public ProductDTO getProductById(Long id) throws NotFoundException {
//
//
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "https://fakestoreapi.com/products/" + id;
//        Products productModel = restTemplate.getForObject(url, Products.class);
//
//        System.out.println(productModel);
//
//        if (productModel == null) {
//            throw new NotFoundException();
//        }
//        return convertToDto(productModel);
//
//    }
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
//    public void getAllProducts(String categoryName) {
//        List<Products> productsList = productRepo.findByCategoryName(categoryName);
//        for(Products p:productsList)
//            System.out.println(p.getCategory().getCategoryName() +" "+ p.getTitle());
//    }
}