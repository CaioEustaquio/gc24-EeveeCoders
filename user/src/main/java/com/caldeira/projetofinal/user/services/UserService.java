package com.caldeira.projetofinal.user.services;

import com.caldeira.projetofinal.user.repositories.UserRepository;
import com.caldeira.projetofinal.validators.UserRequestValidator;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRequestValidator userRequestValidator;
    public UserService(UserRepository userRepository, UserRequestValidator userRequestValidator){
        this.userRepository = userRepository;
        this.userRequestValidator = userRequestValidator;
    }


}
