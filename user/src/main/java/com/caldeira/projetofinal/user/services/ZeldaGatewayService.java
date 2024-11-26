package com.caldeira.projetofinal.user.services;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZeldaGatewayService {
    private final RestTemplate restTemplate;

    public ZeldaGatewayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
