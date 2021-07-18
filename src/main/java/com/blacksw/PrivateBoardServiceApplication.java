package com.blacksw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = PrivateBoardServiceApplication.class)
public class PrivateBoardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateBoardServiceApplication.class, args);
	}

}
