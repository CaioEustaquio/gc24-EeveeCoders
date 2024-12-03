package com.caldeira.projetofinal.zelda.controllers;

import com.caldeira.projetofinal.zelda.models.GameModel;
import com.caldeira.projetofinal.zelda.models.GameResponseModel;
import com.caldeira.projetofinal.zelda.services.ZeldaGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        return new ResponseEntity<>(zeldaGatewayService.getAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<GameModel> getById(@PathVariable String id) {
        GameModel game = zeldaGatewayService.getById(id);
        if (game != null){
            return new ResponseEntity<>(game, HttpStatus.OK);
        }
        return ResponseEntity.status(404).body(null);
    }

    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<List<GameModel>> getAllByName(@PathVariable String name){
        return new ResponseEntity<>(zeldaGatewayService.getAllByName(name), HttpStatus.OK);
    }
}
