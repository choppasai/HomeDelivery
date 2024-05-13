package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.dto.BatchDTO;
import HomeDelivery.Ecommerce.dto.InstructorDTO;
import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.Batch;
import HomeDelivery.Ecommerce.models.InstructorModel;
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
        return userService.createNewUser(userDTO.getName()
        ,userDTO.getEmail());
    }
    @GetMapping("/{name}")
    public @ResponseBody Optional<UserModel> getUser(@PathVariable String name){
        return userService.getByUser(name);
    }
    @PostMapping("/batch")
    public Batch createNewBatch(@RequestBody BatchDTO batchDTO){
        return userService.createBatch(batchDTO.getBatch_Name(),batchDTO.getStrength());
    }
//    @PostMapping("/instructor")
//    public @ResponseBody InstructorModel addInstrucor(@RequestBody InstructorDTO instructorDTO){
//        return userService.createNewInstructor(instructorDTO.getSkill(), instructorDTO.getEmailId(), instructorDTO.getBatchDTO());
//    }
}
