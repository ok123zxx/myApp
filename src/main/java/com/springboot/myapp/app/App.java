package com.springboot.myapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration

@EnableJpaRepositories("com.springboot.myapp.dao")//jpa扫包配置
@EntityScan("com.springboot.myapp.entity")//jpa扫包配置

@ComponentScan(basePackages = {"com.springboot.myapp.service","com.springboot.myapp.web","com.springboot.myapp.handler"})
//注意这里扫包不能直接扫，com.springboot.myapp，启动报错 If you want an embedded database please put a supported one on the classpath

public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
