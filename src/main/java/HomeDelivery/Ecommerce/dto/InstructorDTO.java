package HomeDelivery.Ecommerce.dto;

import HomeDelivery.Ecommerce.models.Batch;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class InstructorDTO {
    private String skill;
    private String emailId;
    private String name;
    private List<BatchDTO> batchDTO;

}
