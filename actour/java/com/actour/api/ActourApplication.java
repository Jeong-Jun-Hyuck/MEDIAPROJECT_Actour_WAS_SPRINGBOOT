package com.actour.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
@MapperScan(basePackages="com.actour.api.mapper")
public class ActourApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(ActourApplication.class, args);
	}

}
