package HomeDelivery.Ecommerce.dto;

import HomeDelivery.Ecommerce.models.Products;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private Integer cartId;

}
