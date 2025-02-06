package HomeDelivery.Ecommerce.controllers;

import HomeDelivery.Ecommerce.Exceptions.EmailExistsException;
import HomeDelivery.Ecommerce.dto.UserDTO;
import HomeDelivery.Ecommerce.models.UserModel;
import HomeDelivery.Ecommerce.services.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;


import java.util.UUID;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    private UserDTO userDTO;
    private UserModel userModel;
    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void setup() {
        userDTO = new UserDTO();
        userDTO.setName("Sai");
        userDTO.setEmail("sai@gmail.com");
        userDTO.setAddress("kadapa");

        userModel = new UserModel();
        userModel.setName("Sai");
        userModel.setUserId(UUID.randomUUID());
        userModel.setAddress("kadapa");
        userModel.setEmailId("sai@gmail.com");
    }

    @Test
    void createUser_withValidData() throws Exception {
        when(userService.createNewUser(any(UserDTO.class))).thenReturn(userModel);
        mockMvc.perform(post("http://localhost:8080/user/creation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userDTO)))
//                .andDo(print())
                .andExpect(jsonPath("$.name").value("Sai"))
                .andExpect(jsonPath("$.address").value("kadapa"))
                .andExpect(jsonPath("$.emailId").value("sai@gmail.com"))
                .andExpect(status().isOk());
                verify(userService,times(1)).createNewUser(any(UserDTO.class));
    }

    @Test
    public void createUser_DuplicateEmail_ShouldReturnConflict() throws Exception {
        userDTO = new UserDTO();
        userDTO.setName("raju");
        userDTO.setEmail("sai@gmail.com");
        userDTO.setAddress("kadapa");

        when(userService.createNewUser(any(UserDTO.class)))
                .thenThrow(new EmailExistsException("Email already exists"));

        mockMvc.perform(post("http://localhost:8080/user/creation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userDTO)))
                .andExpect(status().isConflict())
                .andExpect(content().string(containsString("Email already exists")));

        verify(userService, times(1)).createNewUser(any(UserDTO.class));
    }
@Test
public void createUser_NullRequestBody_ShouldReturnBadRequest() throws Exception {
    mockMvc.perform(post("http://localhost:8080/user/creation")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
}
//@Test
//public void createUser_InternalServerError() throws Exception {
//    when(userService.createNewUser(any(UserDTO.class)))
//            .thenThrow(new RuntimeException("Unexpected error"));
//
//    mockMvc.perform(post("/creation")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(new ObjectMapper().writeValueAsString(userDTO)))
//            .andExpect(status().isInternalServerError())
//            .andExpect(content().string(containsString("Unexpected error")));
//}



    @Test
    void createUser_withInValidData() {

    }

    @Test
    void getUser() {
    }
}