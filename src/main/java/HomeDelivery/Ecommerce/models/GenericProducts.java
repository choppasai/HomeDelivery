package HomeDelivery.Ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;
import org.springdoc.core.converters.models.PageableAsQueryParam;

@Entity
@Data

public class GenericProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;
}
