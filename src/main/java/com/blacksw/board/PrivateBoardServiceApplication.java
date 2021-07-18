package com.blacksw.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blacksw")
public class PrivateBoardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivateBoardServiceApplication.class, args);
	}

}
