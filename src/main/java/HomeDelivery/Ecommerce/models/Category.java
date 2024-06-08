package HomeDelivery.Ecommerce.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private Set<Products> products;
}
