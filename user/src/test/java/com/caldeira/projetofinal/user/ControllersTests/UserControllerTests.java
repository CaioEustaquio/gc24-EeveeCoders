package com.caldeira.projetofinal.user.ControllersTests;

import com.caldeira.projetofinal.user.controllers.UserController;
import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import com.caldeira.projetofinal.user.models.response.UserResponseModel;
import com.caldeira.projetofinal.user.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTests {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private UUID userId;
    private UserResponseModel mockUser;
    private UserRequestModel requestModel;

    @BeforeEach
    public void setIDResponseRequest() {
        MockitoAnnotations.openMocks(this);
        userId = UUID.randomUUID();
        mockUser = new UserResponseModel(userId, "Vinicius", "Silva", LocalDateTime.now());
        requestModel = new UserRequestModel("Vinicius", "Silva");
    }

    @Test
    public void testGetAll() {
        List<UserResponseModel> users = List.of(mockUser);
        when(userService.getAll()).thenReturn(users);
        ResponseEntity<List<UserResponseModel>> response = userController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetById() {
        when(userService.getById(userId)).thenReturn(mockUser);
        ResponseEntity<UserResponseModel> response = userController.getById(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    @Test
    public void testGetByIdNotFound() {
        when(userService.getById(userId)).thenReturn(null);
        ResponseEntity<UserResponseModel> response = userController.getById(userId);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testCreate() {
        when(userService.create(requestModel)).thenReturn(mockUser);
        ResponseEntity<UserResponseModel> response = userController.create(requestModel);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    @Test
    public void testCreateBadRequest() {
        when(userService.create(requestModel)).thenThrow(new IllegalArgumentException());
        ResponseEntity<UserResponseModel> response = userController.create(requestModel);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testUpdate() {
        when(userService.update(userId, requestModel)).thenReturn(mockUser);
        ResponseEntity<UserResponseModel> response = userController.update(requestModel, userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
    }

    @Test
    public void testUpdateNotFound() {
        when(userService.update(userId, requestModel)).thenReturn(null);
        ResponseEntity<UserResponseModel> response = userController.update(requestModel, userId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testUpdateBadRequest() {
        when(userService.update(userId, requestModel)).thenThrow(new IllegalArgumentException());
        ResponseEntity<UserResponseModel> response = userController.update(requestModel, userId);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testDelete() {
        when(userService.deleteById(userId)).thenReturn(true);
        ResponseEntity<HttpStatus> response = userController.delete(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testDeleteNotFound() {
        when(userService.deleteById(userId)).thenReturn(false);
        ResponseEntity<HttpStatus> response = userController.delete(userId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
