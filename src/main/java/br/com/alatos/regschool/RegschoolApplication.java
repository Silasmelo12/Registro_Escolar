package br.com.alatos.regschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class RegschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegschoolApplication.class, args);
	}

	@GetMapping
	public String hello(){
		return "hello";
	}
}
