package com.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"controller"}) 
@EntityScan(basePackages = {"models"})
@EnableJpaRepositories(basePackages = {"repository"})
public class ScheduleVersaoDoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleVersaoDoisApplication.class, args);
	}
	
	//Para quem esta retornando o erro "there was an unexpected error 
//	(type=not found status=404). no message available",  "
//	+ "e esta usando o spring 2.0, pode ser que vc deva colocar na "
//	+ "classe EventoappApplication a anotação @ComponentScan({"com.eventosapp.controllers"}) "
//	+ "para quem esta fazendo o exemplo igual ao do video

}
