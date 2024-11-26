package com.caldeira.projetofinal.zelda.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class GameListResponseModel {
    String name;
    String description;
    String developer;
    String publisher;
    LocalDateTime released_date;
    UUID id;
}
