package services;

import Exceptions.NotFoundException;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends NotFoundException{
    private ProductDTO productDTO;
    public ProductService(ProductDTO productDTO){
        this.productDTO = productDTO;
    }
    //    this is website will have fake api we can use for this project
    //    https://fakestoreapi.com/

    public ProductDTO getDetailsById(int id) throws NotFoundException {
        ProductDTO productDto = new ProductDTO();
//        Integrating a third-party API in a Spring Boot application involves making HTTP requests to external services, fetching data, and handling responses within your Spring Boot application.
//        This can be done using various methods such as RESTful API calls, HTTP clients, and libraries like Retrofit, RestTemplate, Feign, etc.
        String url = "https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate = new RestTemplate();
//      Product_model.class - will get the data in object format with help of get for object. and storing in model class
        ProductModel productModel = restTemplate.getForObject(url,ProductModel.class);
        if(productModel==null){
            throw new NotFoundException();
        }
        productDto.setId(productModel.getId());
        productDto.setTitle(productModel.getTitle());
        productDto.setPrice(productModel.getPrice());
        System.out.println(productDto);
        return productDto;
    }
    public ProductDTO convertToDTO(ProductModel productModel){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(productModel.getId());
        productDto.setTitle(productModel.getTitle());
        productDto.setPrice(productModel.getPrice());
        return productDto;
    }
    public List<ProductDTO> getProducts() {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://fakestoreapi.com/products/";
        ProductModel[] productModel = restTemplate.getForObject(url,ProductModel[].class);
        List<ProductDTO> resultList= new ArrayList<>();
        for(ProductModel pm:productModel){
            resultList.add(convertToDTO(pm));
        }
        return resultList;
    }
}
