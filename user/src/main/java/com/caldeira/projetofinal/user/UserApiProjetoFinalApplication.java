package com.caldeira.projetofinal.user;

import com.caldeira.projetofinal.user.config.EnvironmentConfig;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiProjetoFinalApplication {

	public static void main(String[] args) {
		EnvironmentConfig.loadEnvironmentVariables();
		SpringApplication.run(UserApiProjetoFinalApplication.class, args);
	}
}
