package com.caldeira.projetofinal.user.models.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseModel {
    UUID id;
    String firstName;
    String lastName;
    LocalDateTime creationDate;
}
