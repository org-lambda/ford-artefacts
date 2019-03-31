package com.example.uk.ford;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class FordApplication {

	public static void main(String[] args) {
		SpringApplication.run(FordApplication.class, args);
	}

}
