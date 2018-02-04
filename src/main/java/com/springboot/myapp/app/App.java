package com.springboot.myapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.springboot.myapp.dao")
@EntityScan("com.springboot.myapp.entity")
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.springboot.myapp.service","com.springboot.myapp.web"})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
