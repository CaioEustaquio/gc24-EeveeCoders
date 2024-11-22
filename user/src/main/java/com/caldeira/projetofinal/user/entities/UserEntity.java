package com.caldeira.projetofinal.user.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table (name = "user_entity")
public class UserEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDateTime creationDate;

    //construtor explicito padrao
    public UserEntity(UUID id, String firstName, String lastName, LocalDateTime creationDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.creationDate = creationDate;
    }

    //construtor explicito, JPA precisa para instanciar
    public UserEntity(){}
}
