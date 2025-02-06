package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Data

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_id", columnDefinition = "BINARY(16)")
    private UUID cartId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Products> productsList;
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;
}
