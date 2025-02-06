package HomeDelivery.Ecommerce.Exceptions;

import lombok.Getter;

@Getter
public class EmailExistsException extends Exception {
    private String message;
    public EmailExistsException(String message){
        super(message);
    }
}
