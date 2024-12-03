package com.caldeira.projetofinal.zelda.controllers;

import com.caldeira.projetofinal.zelda.models.GameListResponseModel;
import com.caldeira.projetofinal.zelda.models.GameModel;
import com.caldeira.projetofinal.zelda.services.ZeldaGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zelda")
public class ZeldaController {

    @Autowired
    private ZeldaGatewayService zeldaGatewayService;

    @GetMapping("/get-all")
    public ResponseEntity<GameListResponseModel> getAll(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        List<GameModel> games = zeldaGatewayService.getAll(page, size);
        GameListResponseModel response = new GameListResponseModel(true, games.size(),  games);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GameModel> getById(@PathVariable("id") String id) {
        GameModel gameModel = zeldaGatewayService.getById(id);
        if (gameModel != null) {
            return ResponseEntity.ok(gameModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
