package com.caldeira.projetofinal.user.services;

import com.caldeira.projetofinal.user.entities.UserEntity;
import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import com.caldeira.projetofinal.user.models.response.UserResponseModel;
import com.caldeira.projetofinal.user.repositories.UserRepository;
import com.caldeira.projetofinal.user.validators.UserRequestValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRequestValidator userRequestValidator;
    public UserService(UserRepository userRepository, UserRequestValidator userRequestValidator){
        this.userRepository = userRepository;
        this.userRequestValidator = userRequestValidator;
    }

    public List<UserResponseModel> getAll(){

        List<UserEntity> usersList = this.userRepository.findAll();

        return usersList.stream()
                .map(user -> new UserResponseModel(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getCreationDate()
                ))
                .collect(Collectors.toList());
    };

    public UserResponseModel getById(UUID id){

        UserEntity user = this.userRepository.findById(id).orElse(null);

        if(user == null) {
            return null;
        }

        return new UserResponseModel(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getCreationDate()
        );
    }

    public UserResponseModel create(UserRequestModel requestModel){

        this.userRequestValidator.validate(requestModel);

        UserEntity newUser = new UserEntity(
            UUID.randomUUID(),
            requestModel.getFirstName(),
            requestModel.getLastName(),
            LocalDateTime.now()
        );

        UserEntity savedUser = this.userRepository.save(newUser);

        return new UserResponseModel(
            savedUser.getId(),
            savedUser.getFirstName(),
            savedUser.getLastName(),
            savedUser.getCreationDate()
        );
    }

    public UserResponseModel update(UUID id, UserRequestModel requestModel){

        this.userRequestValidator.validate(requestModel);

        UserEntity existingUser = this.userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            return null;
        }

        existingUser.setFirstName(requestModel.getFirstName());
        existingUser.setLastName(requestModel.getLastName());

        UserEntity updatedUser = this.userRepository.save(existingUser);

        return new UserResponseModel(
            updatedUser.getId(),
            updatedUser.getFirstName(),
            updatedUser.getLastName(),
            updatedUser.getCreationDate()
        );
    }
}
