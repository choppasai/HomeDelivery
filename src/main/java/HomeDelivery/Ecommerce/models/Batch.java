package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Batch_id;
    private String batch_name;
    @ManyToOne
    private InstructorModel instructorModel;
    private int strength;
}
