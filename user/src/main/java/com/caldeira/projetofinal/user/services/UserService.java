package com.caldeira.projetofinal.user.services;

import com.caldeira.projetofinal.user.entities.UserEntity;
import com.caldeira.projetofinal.user.models.response.UserResponseModel;
import com.caldeira.projetofinal.user.repositories.UserRepository;
import com.caldeira.projetofinal.validators.UserRequestValidator;
import org.springframework.stereotype.Service;

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
}
