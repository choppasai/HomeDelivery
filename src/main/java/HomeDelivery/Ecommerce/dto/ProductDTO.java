package HomeDelivery.Ecommerce.dto;

import HomeDelivery.Ecommerce.models.Products;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Getter
@Setter
public class ProductDTO{
    private String title;
    private long price;
    private String category;
    private String seller;
    public ProductDTO(){}
    public ProductDTO(Products products){
        this.title = products.getTitle();
        price = products.getPrice();
        category = products.getCategory().getCategoryName();
        seller = products.getSeller();
    }
    public static ProductDTO toProductDTO(Products products){
        return new ProductDTO(products);
    }

}
