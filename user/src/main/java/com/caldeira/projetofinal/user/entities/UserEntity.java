package com.caldeira.projetofinal.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table (name = "user_entity")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "creation_date")
    private LocalDateTime creationDate;
}
