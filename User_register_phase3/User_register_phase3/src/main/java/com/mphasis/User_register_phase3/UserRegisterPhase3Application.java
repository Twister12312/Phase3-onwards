package com.mphasis.User_register_phase3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("Controller")
@EntityScan("entities")
@SpringBootApplication
public class UserRegisterPhase3Application {

	public static void main(String[] args) {
		SpringApplication.run(UserRegisterPhase3Application.class, args);
	}

}
