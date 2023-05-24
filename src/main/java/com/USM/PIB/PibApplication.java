package com.USM.PIB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PibApplication {

	public static void main(String[] args) {
		SpringApplication.run(PibApplication.class, args);
	}

}
