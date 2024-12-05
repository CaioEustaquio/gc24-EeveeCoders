package com.caldeira.projetofinal.zelda.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class GameModel {
    private String id;
    private String name;
    private String description;
    private String developer;
    private String publisher;
    @JsonProperty("released_date")
    private String releasedDate;
}
