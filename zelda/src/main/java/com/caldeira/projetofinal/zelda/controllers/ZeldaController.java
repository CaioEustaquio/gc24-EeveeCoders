package com.caldeira.projetofinal.zelda.controllers;

import com.caldeira.projetofinal.zelda.services.ZeldaGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zelda")
public class ZeldaController {

    @Autowired
    private ZeldaGatewayService restTemplate;



}
