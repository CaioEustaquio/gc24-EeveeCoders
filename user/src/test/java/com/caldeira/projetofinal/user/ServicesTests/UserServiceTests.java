package com.caldeira.projetofinal.user.ServicesTests;

import com.caldeira.projetofinal.user.entities.UserEntity;
import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import com.caldeira.projetofinal.user.models.response.UserResponseModel;
import com.caldeira.projetofinal.user.repositories.UserRepository;
import com.caldeira.projetofinal.user.services.UserService;
import com.caldeira.projetofinal.user.validators.UserRequestValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRequestValidator userRequestValidator;

    @InjectMocks
    private UserService userService;

    private UUID userId;
    private UserEntity mockUserEntity;
    private UserRequestModel mockRequestModel;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userId = UUID.randomUUID();
        mockUserEntity = new UserEntity(
                userId,
                "Vinicius",
                "Silva",
                LocalDateTime.now()
        );
        mockRequestModel = new UserRequestModel("Vinicius", "Silva");
    }

    @Test
    public void testGetAll() {
        List<UserEntity> userEntities = List.of(mockUserEntity);
        when(userRepository.findAll()).thenReturn(userEntities);

        List<UserResponseModel> responseModels = userService.getAll();

        assertEquals(1, responseModels.size());
        assertEquals(mockUserEntity.getId(), responseModels.get(0).getId());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testGetByIdSuccess() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUserEntity));

        UserResponseModel responseModel = userService.getById(userId);

        assertNotNull(responseModel);
        assertEquals(mockUserEntity.getId(), responseModel.getId());
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testGetByIdNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        UserResponseModel responseModel = userService.getById(userId);

        assertNull(responseModel);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    public void testCreateSuccess() {
        when(userRepository.save(any(UserEntity.class))).thenReturn(mockUserEntity);

        UserResponseModel responseModel = userService.create(mockRequestModel);

        assertNotNull(responseModel);
        assertEquals(mockUserEntity.getId(), responseModel.getId());
        verify(userRequestValidator, times(1)).validate(mockRequestModel);
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testUpdateSuccess() {
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUserEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(mockUserEntity);

        UserResponseModel responseModel = userService.update(userId, mockRequestModel);

        assertNotNull(responseModel);
        assertEquals(mockUserEntity.getId(), responseModel.getId());
        verify(userRequestValidator, times(1)).validate(mockRequestModel);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(mockUserEntity);
    }

    @Test
    public void testUpdateNotFound() {
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        UserResponseModel responseModel = userService.update(userId, mockRequestModel);

        assertNull(responseModel);
        verify(userRequestValidator, times(1)).validate(mockRequestModel);
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).save(any(UserEntity.class));
    }

    @Test
    public void testDeleteByIdSuccess() {
        when(userRepository.existsById(userId)).thenReturn(true);

        boolean result = userService.deleteById(userId);

        assertTrue(result);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void testDeleteByIdNotFound() {
        when(userRepository.existsById(userId)).thenReturn(false);

        boolean result = userService.deleteById(userId);

        assertFalse(result);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, never()).deleteById(any(UUID.class));
    }
}
