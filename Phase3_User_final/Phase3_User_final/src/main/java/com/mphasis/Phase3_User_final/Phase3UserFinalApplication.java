package com.mphasis.Phase3_User_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("Controller")
@EntityScan("entities")
@SpringBootApplication
public class Phase3UserFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Phase3UserFinalApplication.class, args);
	}

}
