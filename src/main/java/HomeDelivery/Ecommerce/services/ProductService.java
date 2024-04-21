package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Exceptions.NotFoundException;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import HomeDelivery.Ecommerce.models.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public ProductDTO getProductById(Long id) throws NotFoundException {


        RestTemplate restTemplate = new RestTemplate();

        String url = "https://fakestoreapi.com/products/" + id;
        ProductModel productModel = restTemplate.getForObject(url, ProductModel.class);

        System.out.println(productModel);

        if (productModel == null) {
            throw new NotFoundException();
        }

        // Call the DB
        // Call the Fake Store API.
        // https://fakestoreapi.com/products/15
        return convertToDto(productModel);

    }

    private static ProductDTO convertToDto(ProductModel productModel) {
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
        ProductModel[] products = restTemplate.getForObject(url, ProductModel[].class);

        List<ProductDTO> returnedProducts = new ArrayList<>();

        for (ProductModel product: products) {
            returnedProducts.add(convertToDto(product));
        }
        return returnedProducts;
    }
}