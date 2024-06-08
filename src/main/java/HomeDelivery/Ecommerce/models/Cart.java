package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @OneToMany
    private List<Products> productsList;
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
