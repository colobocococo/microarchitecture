package com.coloboc.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(ClientApplication.class, args);
	}
}
