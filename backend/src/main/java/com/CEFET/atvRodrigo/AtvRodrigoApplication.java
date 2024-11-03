package com.CEFET.atvRodrigo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "Api CEFET"))
public class AtvRodrigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtvRodrigoApplication.class, args);
	}
/*TODO
*  corrigir o controler ClientController*/
}
