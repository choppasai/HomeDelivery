package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Exceptions.EmailExistsException;
import HomeDelivery.Ecommerce.Repository.CartRepo;
import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.models.Products;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final CartRepo cartRepo;
    private final CartService cartService;


    public UserService(UserRepo userRepo, CartRepo cartRepo,CartService cartService) {
        this.userRepo = userRepo;
        this.cartService = cartService;
        this.cartRepo = cartRepo;
    }
    public void emailCheck(String email) throws EmailExistsException {
        if (!userRepo.findByEmail(email).getEmailId().isEmpty()) {
            throw new EmailExistsException("Email already exists: " + email);
        }
    }

    public UserModel createNewUser(UserDTO userDTO) throws EmailExistsException {
        emailCheck(userDTO.getEmail());
        UserModel userModel = new UserModel();
        userModel.setName(userDTO.getName());
        userModel.setEmailId(userDTO.getEmail());
        userModel.setAddress(userDTO.getAddress());

        userModel = userRepo.save(userModel);
        Cart cart = cartService.createCart(userModel);
        userModel.setCart(cart);
        cartRepo.save(cart);
        return userRepo.save(userModel);
    }
    public Optional<UserModel> getByUser(String name){
        return userRepo.findByName(name);
    }

}
