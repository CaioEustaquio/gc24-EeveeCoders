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
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDateTime creationDate;
}
