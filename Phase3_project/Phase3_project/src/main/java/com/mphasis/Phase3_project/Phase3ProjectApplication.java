package com.mphasis.Phase3_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Controller")
@EntityScan("entities")
//zz
public class Phase3ProjectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(Phase3ProjectApplication.class);
	}

	
	public static void main(String[] args) {
		SpringApplication.run(Phase3ProjectApplication.class, args);
	}

}
