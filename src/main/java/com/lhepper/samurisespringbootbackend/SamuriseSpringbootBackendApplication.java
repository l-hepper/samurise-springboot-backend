package com.lhepper.samurisespringbootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SamuriseSpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamuriseSpringbootBackendApplication.class, args);
	}

	// can be used to load data into the h2 database on start-up
	// @Override
	// public void run(String... args) throws Exception {
	// 	// TODO Auto-generated method stub
	// 	throw new UnsupportedOperationException("Unimplemented method 'run'");
	// }
}
