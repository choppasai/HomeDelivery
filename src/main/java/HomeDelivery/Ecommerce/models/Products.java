package HomeDelivery.Ecommerce.models;

import HomeDelivery.Ecommerce.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private long price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String seller;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
