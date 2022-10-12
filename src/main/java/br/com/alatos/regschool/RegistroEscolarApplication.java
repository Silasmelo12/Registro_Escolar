package br.com.alatos.regschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RegistroEscolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroEscolarApplication.class, args);
	}

	@GetMapping
	public String hello(){
		return "hello";
	}
}
