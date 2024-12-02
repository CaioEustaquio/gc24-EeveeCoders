package com.caldeira.projetofinal.zelda.controllers;

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
    public ResponseEntity<List<GameModel>> getAll(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size
    ) {
        List<GameModel> games = zeldaGatewayService.getAllGames(page, size);
        return ResponseEntity.ok(games);
    }
}
