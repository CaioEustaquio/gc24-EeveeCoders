package com.caldeira.projetofinal.zelda.services;
import com.caldeira.projetofinal.zelda.models.GameModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZeldaGatewayService {
    private final RestTemplate restTemplate;

    public ZeldaGatewayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GameModel getById(String id) {
        String url = String.format("https://zelda.fanapis.com/api/games/%s", id);

        try {
            ResponseEntity<GameModel> response = restTemplate.getForEntity(url, GameModel.class);
            return response.getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
