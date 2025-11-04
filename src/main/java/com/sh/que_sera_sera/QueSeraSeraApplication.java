package com.sh.que_sera_sera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QueSeraSeraApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueSeraSeraApplication.class, args);
	}

	@GetMapping
	public String openingStatement() {
		return "Welcome!";
	}

}
