package com.caldeira.projetofinal.user.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentConfig {

    public static void loadEnvironmentVariables() {
        Dotenv dotenv = Dotenv.configure().systemProperties().load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }
}

