package com.caldeira.projetofinal.zelda.services;

import com.caldeira.projetofinal.zelda.models.GameListResponseModel;
import com.caldeira.projetofinal.zelda.models.GameModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ZeldaGatewayServiceTest {
    @Mock
    private ZeldaGatewayService zeldaGatewayService;
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = Mockito.mock(RestTemplate.class);

        zeldaGatewayService = new ZeldaGatewayService(restTemplate);
    }

    @Test
    public void getAllTest() {
        // Criando o objeto esperado
        GameListResponseModel expectedList = new GameListResponseModel();
        expectedList.setSuccess(true);
        expectedList.setCount(1);
        expectedList.setData(List.of(new GameModel(
                "5f6ce9d805615a85623ec2b7",
                " February 21, 1986",
                "The Legend of Zelda is the first installment of the Zelda series...",
                "Nintendo R&D 4",
                "Nintendo",
                " February 21, 1986"
        )));

        // Mock da resposta do RestTemplate
        ResponseEntity<GameListResponseModel> mockedResponse = new ResponseEntity<>(expectedList, HttpStatus.OK);

        // Configuração do mock do exchange
        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(mockedResponse);

        List<GameModel> result = zeldaGatewayService.getAll(0, 1);

        Assertions.assertEquals(expectedList.getData(), result);
    }
}