package com.caldeira.projetofinal.zelda.services;

import com.caldeira.projetofinal.zelda.fixtures.TestFixtures;
import com.caldeira.projetofinal.zelda.models.GameListResponseModel;
import com.caldeira.projetofinal.zelda.models.GameModel;
import com.caldeira.projetofinal.zelda.models.GameResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        GameListResponseModel expectedList = new GameListResponseModel();
        expectedList.setSuccess(true);
        expectedList.setCount(1);
        expectedList.setData(List.of(TestFixtures.getFixedGameListModel().getFirst()));

        ResponseEntity<GameListResponseModel> mockedResponse = new ResponseEntity<>(expectedList, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(mockedResponse);

        List<GameModel> result = zeldaGatewayService.getAll(0, 1);

        Assertions.assertEquals(expectedList.getData(), result);
    }

    @Test
    public void getAllTest_NullParameters(){
        GameListResponseModel expectedList = new GameListResponseModel();
        expectedList.setSuccess(true);
        expectedList.setCount(5);
        expectedList.setData(TestFixtures.getFixedGameListModel());

        ResponseEntity<GameListResponseModel> mockedResponse = new ResponseEntity<>(expectedList, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(mockedResponse);

        List<GameModel> result = zeldaGatewayService.getAll(null, null);

        Assertions.assertEquals(expectedList.getData(), result);
    }

    @Test
    public void getAllTest_EmptyResponse() {
        GameListResponseModel emptyList = new GameListResponseModel();
        emptyList.setSuccess(true);
        emptyList.setCount(0);
        emptyList.setData(null); // Lista vazia

        ResponseEntity<GameListResponseModel> mockedResponse = new ResponseEntity<>(emptyList, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(mockedResponse);

        List<GameModel> result = zeldaGatewayService.getAll(0, 0);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void getByIdTest(){
        GameResponseModel expectedResponse = new GameResponseModel(true, TestFixtures.getFixedGameListModel().get(1));

        ResponseEntity<GameResponseModel> mockedResponse = new ResponseEntity<>(expectedResponse, HttpStatus.OK);

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(mockedResponse);

        GameModel result = zeldaGatewayService.getById("5f6ce9d805615a85623ec2b8");

        Assertions.assertEquals(expectedResponse.getData(), result);
    }

    @Test
    public void getByIdTest_InvalidId(){
        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(new ResponseEntity<>(new GameResponseModel(false, null), HttpStatus.BAD_REQUEST));

        GameModel result = zeldaGatewayService.getById("randominvalidid");

        Assertions.assertNull(result);
    }

    @Test
    public void getByIdTest_EmptyId(){
        GameModel result = zeldaGatewayService.getById("");
        Assertions.assertNull(result);
    }

    @Test
    public void getAllByNameTest(){
        GameListResponseModel expectedResponse = new GameListResponseModel();
        expectedResponse.setSuccess(true);
        expectedResponse.setCount(1);
        expectedResponse.setData(List.of(TestFixtures.getByNameHyruleWarriors()));

        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.OK));

        List<GameModel> result = zeldaGatewayService.getAllByName("Hyrule Warriors Legends");

        Assertions.assertEquals(expectedResponse.getData(), result);
    }

    @Test
    public void getAllByNameTest_EmptyRequest(){
        List<GameModel> result = zeldaGatewayService.getAllByName("");
        Assertions.assertNull(result);
    }

    @Test
    public void getAllByNameTest_NameNotFound(){
        GameListResponseModel expectedResponse = new GameListResponseModel();
        expectedResponse.setSuccess(true);
        expectedResponse.setCount(0);
        expectedResponse.setData(List.of());
        Mockito.when(restTemplate.exchange(
                Mockito.anyString(),
                Mockito.eq(HttpMethod.GET),
                Mockito.isNull(),
                Mockito.any(ParameterizedTypeReference.class))
        ).thenReturn(new ResponseEntity<>(expectedResponse, HttpStatus.BAD_REQUEST));

        List<GameModel> result = zeldaGatewayService.getAllByName("invalid name");

        Assertions.assertEquals(result, expectedResponse.getData());
    }
}