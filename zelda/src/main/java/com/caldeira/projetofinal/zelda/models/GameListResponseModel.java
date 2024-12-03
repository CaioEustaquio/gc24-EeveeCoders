package com.caldeira.projetofinal.zelda.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class GameListResponseModel {
    private Boolean success;
    private Integer count;
    private List<GameModel> data;
}
