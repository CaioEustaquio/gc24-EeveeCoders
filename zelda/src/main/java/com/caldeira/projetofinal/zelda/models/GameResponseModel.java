package com.caldeira.projetofinal.zelda.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class GameResponseModel {
    private boolean success;
    private GameModel data;
}
