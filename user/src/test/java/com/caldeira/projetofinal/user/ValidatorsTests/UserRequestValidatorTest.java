package com.caldeira.projetofinal.user.ValidatorsTests;

import com.caldeira.projetofinal.user.models.request.UserRequestModel;
import com.caldeira.projetofinal.user.validators.UserRequestValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRequestValidatorTest {
    private UserRequestValidator validator;

    @BeforeEach
    public void setValidator() {
        validator = new UserRequestValidator();
    }

    @Test
    public void testValidateFirstSecondOK (){
        UserRequestModel modelExemple = new UserRequestModel("Vinicius","Silva");
        assertDoesNotThrow(() -> validator.validate(modelExemple));
    }

    @Test
    public void testValidateFirstNameNull(){
        UserRequestModel modelExemple = new UserRequestModel(null,"Silva");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(modelExemple));
        assertEquals("'firstName' cannot be null or less than 3 characters long.", exception.getMessage());
    }

    @Test
    public void testValidateFirstNameLessThan3(){
        UserRequestModel modelExemple = new UserRequestModel("Vi","Silva");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(modelExemple));
        assertEquals("'firstName' cannot be null or less than 3 characters long.", exception.getMessage());
    }

    @Test
    public void testValidateSecNameNull() {
        UserRequestModel modelExemple = new UserRequestModel("Vinicius",null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(modelExemple));
        assertEquals("'lastName' cannot be null or less than 3 characters long.", exception.getMessage());
    }

    @Test
    public void testValidateSecNameLassThan3() {
        UserRequestModel modelExemple = new UserRequestModel("Vinicius","Si");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(modelExemple));
        assertEquals("'lastName' cannot be null or less than 3 characters long.", exception.getMessage());
    }
}
