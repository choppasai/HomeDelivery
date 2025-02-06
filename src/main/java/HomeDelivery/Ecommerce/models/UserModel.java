package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.UUID;

@Getter
@Setter
@Entity
//kind of inheritance where parent class act as abstract
//when ever mappedsuperclass is used. entity annotations should not use.
//@MappedSuperclass
//@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id",columnDefinition = "BINARY(16)")
    private UUID userId;
    private String name;
    private String address;
    private String emailId;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
