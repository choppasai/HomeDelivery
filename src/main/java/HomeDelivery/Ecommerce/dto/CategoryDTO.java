package HomeDelivery.Ecommerce.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
public class CategoryDTO {
    private int categoryID;
    private String categoryName;
}
