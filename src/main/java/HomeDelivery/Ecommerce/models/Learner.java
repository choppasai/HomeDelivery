package HomeDelivery.Ecommerce.models;

import HomeDelivery.Ecommerce.controllers.UserController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Learner {
    @Id
    @GeneratedValue
    private UUID learner_id;
    private String Learner_name;
    private String university;
}
