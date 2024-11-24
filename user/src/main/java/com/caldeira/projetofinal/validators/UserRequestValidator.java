package com.caldeira.projetofinal.validators;

import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import org.springframework.stereotype.Component;
@Component
public class UserRequestValidator {
    public void validate(UserRequestModel model){
        if (model.getFirstName() == null || model.getFirstName().length() < 3) {
            throw new IllegalArgumentException("'firstName' cannot be null or less than 3 characters long.");
        }
        if (model.getLastName() == null || model.getLastName().length() < 3) {
            throw new IllegalArgumentException("'lastName' cannot be null or less than 3 characters long.");
        }
    }
}
