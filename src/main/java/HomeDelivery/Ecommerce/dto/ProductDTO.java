package HomeDelivery.Ecommerce.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class ProductDTO {
    private int id;
    private String title;
    private long price;
    private String category;
    private String seller;
}
