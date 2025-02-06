package HomeDelivery.Ecommerce.services;

import HomeDelivery.Ecommerce.Exceptions.EmailExistsException;
import HomeDelivery.Ecommerce.dto.*;
import HomeDelivery.Ecommerce.Repository.CartRepo;
import HomeDelivery.Ecommerce.Repository.UserRepo;
import HomeDelivery.Ecommerce.models.Cart;
import HomeDelivery.Ecommerce.models.UserModel;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private CartService cartService;
    @Mock
    private UserRepo userRepo;
    @Mock
    private CartRepo cartRepo;
    @InjectMocks
    private UserService userService;

    private UserDTO userDTO;
    private UserModel userModel;
    private Cart cart;

    @BeforeEach
    public void setUp(){
        userDTO = new UserDTO();
        userDTO.setName("Sai");
        userDTO.setEmail("Sai@gmail.com");
        userDTO.setAddress("kadapa");

        userModel = new UserModel();
        userModel.setUserId(UUID.randomUUID());
        userModel.setName("Sai");
        userModel.setAddress("kadapa");
        userModel.setEmailId("Sai@gmail.com");

        cart = new Cart();
        cart.setProductsList(new ArrayList<>());
        cart.setUserId(userModel.getUserId());
    }

    @Test
    void createNewUser() throws EmailExistsException {

        when(userRepo.save(ArgumentMatchers.any())).thenReturn(userModel);
        when(cartService.createCart(userModel)).thenReturn(cart);

        UserModel userModel1 = userService.createNewUser(userDTO);

        assertNotNull(userModel1);
        assertNotNull(userModel1.getUserId());
        assertNotNull(cart);
        assertEquals(userDTO.getName(), userModel1.getName());
        assertEquals(userDTO.getEmail(), userModel1.getEmailId());
        assertEquals(userDTO.getAddress(), userModel1.getAddress());

        verify(cartService, times(1)).createCart(userModel1);
        verify(cartRepo, times(1)).save(Mockito.any(Cart.class));
        verify(userRepo, times(2)).save(Mockito.any(UserModel.class));
    }



    @Test
    void getByUser_ShouldReturnUser_WhenUserExists() {

        when(userRepo.findByName("sai")).thenReturn(Optional.of(userModel));

        Optional<UserModel> result = userService.getByUser("sai");


        assertTrue(result.isPresent(), "Result should be present");

        assertEquals("sai".toLowerCase(), result.get().getName().toLowerCase(), "User name should match");
        verify(userRepo, times(1)).findByName("sai");
    }
    @Test
    void getByUser_ShouldReturnEmpty_WhenUserDoesNotExist() {

        when(userRepo.findByName("paandu")).thenReturn(Optional.empty());


        Optional<UserModel> result = userService.getByUser("paandu");


        assertFalse(result.isPresent(), "Result should be empty");
        verify(userRepo, times(1)).findByName("paandu");
    }
}