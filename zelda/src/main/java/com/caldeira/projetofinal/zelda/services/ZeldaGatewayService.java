package com.caldeira.projetofinal.zelda.services;
import com.caldeira.projetofinal.zelda.models.GameListResponseModel;
import com.caldeira.projetofinal.zelda.models.GameModel;
import com.caldeira.projetofinal.zelda.models.GameResponseModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class ZeldaGatewayService {
    private final RestTemplate restTemplate;

    public ZeldaGatewayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GameModel> getAll(Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null){
            size = 5;
        }

        String url = String.format("https://zelda.fanapis.com/api/games?page=%dlimit=%d", page, size);
        GameListResponseModel games = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<GameListResponseModel>(){
        }).getBody();

        if (games.getSuccess() && games.getData() != null){
           return games.getData();
        }

        return Collections.EMPTY_LIST;
    }

    public GameModel getById(String id) {
        if (id == null || id.isEmpty()){
            return null;
        }

        String url = String.format("https://zelda.fanapis.com/api/games/%s", id);

        try {
            GameResponseModel game = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<GameResponseModel>() {
            }).getBody();
            return game == null ? null : game.getData();
        }
        catch (Exception e){
            return null;
        }
    }

    public List<GameModel> getAllByName(String name){
        if (name == null || name.isEmpty()){
            return null;
        }

        String url = String.format("https://zelda.fanapis.com/api/games?name=%s", name);

        GameListResponseModel games = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<GameListResponseModel>(){
        }).getBody();

        if (games.getSuccess() && games.getData() != null){
            return games.getData();
        }

        return Collections.EMPTY_LIST;
    }

}
