package com.anuj.reactivems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com.anuj.reactivems")
public class SpringBootReactiveMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactiveMsApplication.class, args);
	}

}
