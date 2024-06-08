package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
public class Products{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String title;
    private  long price;
    @ManyToOne
    private Category category;
    private String seller;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
