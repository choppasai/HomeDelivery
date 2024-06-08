package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("")
        public UserModel createUser(@RequestBody UserDTO userDTO){
        return userService.createNewUser(userDTO);
    }
    @GetMapping("/{name}")
    public @ResponseBody Optional<UserModel> getUser(@PathVariable String name){
        return userService.getByUser(name);
    }

}
