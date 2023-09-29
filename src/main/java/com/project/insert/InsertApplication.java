package com.project.insert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class InsertApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertApplication.class, args);
	}

}
