package com.caldeira.projetofinal.zelda.ControllersTest;

import com.caldeira.projetofinal.zelda.controllers.ZeldaController;
import com.caldeira.projetofinal.zelda.models.GameModel;
import java.util.UUID;
import com.caldeira.projetofinal.zelda.services.ZeldaGatewayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public class ControllerZeldaTests {
    @Mock
    private ZeldaGatewayService zeldaGatewayService;

    @InjectMocks
    private ZeldaController zeldaController;

    private GameModel gameModel;
    private String gameID;
    private String gameName;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        gameID = UUID.randomUUID().toString();
        gameName = "The Legend of Zelda";
        gameModel = new GameModel(
                gameID,
                gameName,
                "An epic action-adventure game.",
                "Nintendo",
                "Nintendo",
                "1986-02-21"
        );
    }

    @Test
    public void testGetAll() {
        List<GameModel> games = List.of(gameModel);
        when(zeldaGatewayService.getAll(null, null)).thenReturn(games);

        ResponseEntity<List<GameModel>> response = zeldaController.getAll(null, null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(games, response.getBody());
    }

    @Test
    public void testGetById() {
        when(zeldaGatewayService.getById(gameID)).thenReturn(gameModel);

        ResponseEntity<GameModel> response = zeldaController.getById(gameID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(gameModel, response.getBody());
    }

    @Test
    public void testGetByIdNotFound() {
        when(zeldaGatewayService.getById(gameID)).thenReturn(null);

        ResponseEntity<GameModel> response = zeldaController.getById(gameID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testGetByName() {
        List<GameModel> games = List.of(gameModel);
        when(zeldaGatewayService.getAllByName(gameName)).thenReturn(games);

        ResponseEntity<List<GameModel>> response = zeldaController.getAllByName(gameName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(games, response.getBody());
    }

    @Test
    public void testGetByNameNotFound() {
        when(zeldaGatewayService.getAllByName(gameName)).thenReturn(List.of());

        ResponseEntity<List<GameModel>> response = zeldaController.getAllByName(gameName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(0, response.getBody().size());
    }

}
