package com.escuelaing.edu.co.proyectoIntegrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.escuelaing.edu.co.proyectoIntegrador.repository")
public class ProyectoIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoIntegradorApplication.class, args);
	}

}
