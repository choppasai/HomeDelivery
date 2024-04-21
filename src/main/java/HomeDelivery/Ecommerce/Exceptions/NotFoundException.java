package HomeDelivery.Ecommerce.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NotFoundException extends Exception{
    public NotFoundException(){
        super("The product id is not found");
    }
}
