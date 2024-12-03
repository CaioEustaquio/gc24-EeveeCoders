package com.caldeira.projetofinal.user;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiProjetoFinalApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().systemProperties().load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(UserApiProjetoFinalApplication.class, args);
	}

}
