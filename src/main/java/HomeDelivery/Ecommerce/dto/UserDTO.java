package HomeDelivery.Ecommerce.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String address;
    private String email;
    private CartDTO cartDTO;
}
