package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Repository.CartRepo;
import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.models.Products;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service

public class UserService {
    private final UserRepo userRepo;
    private final CartRepo cartRepo;
    public UserService(UserRepo userRepo, CartRepo cartRepo) {
        this.userRepo = userRepo;

        this.cartRepo = cartRepo;
    }

    public UserModel createNewUser(UserDTO userDTO){
        UserModel userModel = new UserModel();
        userModel.setName(userDTO.getName());
        userModel.setEmailId(userDTO.getEmail());
        userModel.setAddress(userDTO.getAddress());
        Cart cart = new Cart();
        cart.setUser(userModel);
//
        userRepo.save(userModel);
        cartRepo.save(cart);
        return userModel;
    }
    public Optional<UserModel> getByUser(String name){
        return userRepo.findByName(name);
    }

}
