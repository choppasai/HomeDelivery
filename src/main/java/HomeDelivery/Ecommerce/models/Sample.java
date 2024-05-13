package HomeDelivery.Ecommerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class Sample {
    @Id
    public int sample_id;
    public String ranu;
    public String vastha;
}
