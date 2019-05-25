package com.actour.api;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MultipartConfig
public class ActourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActourApplication.class, args);
	}

}
