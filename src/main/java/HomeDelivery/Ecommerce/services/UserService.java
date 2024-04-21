package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public UserModel createNewUser(String name,String email){
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setEmail(email);
        userRepo.save(userModel);
        return userModel;
    }
    public Optional<UserModel> getByUser(String name){
        return userRepo.findByName(name);
    }
}
