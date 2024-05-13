package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter

public class InstructorModel extends UserModel{
    private String skill;
    private String emailId;
    private String name;
    @OneToMany(mappedBy = "instructorModel")
    private List<Batch> batch;
}
