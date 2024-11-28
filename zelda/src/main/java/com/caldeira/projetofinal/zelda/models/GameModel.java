package com.caldeira.projetofinal.zelda.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class GameModel {
    private String name;
    private String description;
    private String developer;
    private String publisher;
    private LocalDateTime released_date;
    private UUID id;
}
