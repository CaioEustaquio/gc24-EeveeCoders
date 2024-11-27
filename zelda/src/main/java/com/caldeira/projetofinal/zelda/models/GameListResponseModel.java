package com.caldeira.projetofinal.zelda.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class GameListResponseModel {
    private Boolean sucess;
    private Integer count;
    private List<GameModel> data;
}
