package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.Exceptions.EmailExistsException;
import HomeDelivery.Ecommerce.Exceptions.GlobalExceptionHandler;
import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/creation")
        public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
            try{
                return ResponseEntity.ok().body(userService.createNewUser(userDTO));
            } catch (EmailExistsException e) {
                return GlobalExceptionHandler.handleEmailExistsException(e);
            }
    }
    @GetMapping("/{name}")
    public @ResponseBody Optional<UserModel> getUser(@PathVariable String name){
        return userService.getByUser(name);
    }

}
