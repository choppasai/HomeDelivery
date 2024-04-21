package HomeDelivery.Ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {
    private int id;
    private  String title;
    private  long price;
    private  String category;
    private  String seller;
}
