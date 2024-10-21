package com.CEFET.atvRodrigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtvRodrigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtvRodrigoApplication.class, args);
	}
/*TODO
*  fazer o flyway funcionar a migração, gerando com ddl para conferir oq foi feito, alterar o yaml*/
}
