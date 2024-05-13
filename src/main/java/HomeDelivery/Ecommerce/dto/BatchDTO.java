package HomeDelivery.Ecommerce.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BatchDTO {
    private int id;
    private String batch_Name;
    private String batch_Instructor;
    private int strength;
    private long psp;
}
