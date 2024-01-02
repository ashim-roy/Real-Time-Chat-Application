package com.WebSoket.Chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

}
/*
1. ChatApplication Class:
This is the entry point of the Spring Boot application. It is annotated with @SpringBootApplication, indicating that
it's a Spring Boot application. The main method is the starting point of the application, and it uses SpringApplication.
run(ChatApplication.class, args); to bootstrap the Spring application.
 */