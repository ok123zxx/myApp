package com.springboot.myapp.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
//springboot注解 = @EnableAutoConfiguration + 扫当前包目录下的类 + @Configuration

@EnableJpaRepositories("com.springboot.myapp.dao")//jpa扫包配置
@EntityScan("com.springboot.myapp.entity")//jpa扫包配置

@MapperScan(basePackages = {
		"com.springboot.myapp.mapper",
		"com.springboot.myapp.mapper.datasrc1Mapper",
		"com.springboot.myapp.mapper.datasrc2Mapper"})//mybatis Mapper扫描

@ComponentScan(basePackages = {
		"com.springboot.myapp.service",
		"com.springboot.myapp.web",
		"com.springboot.myapp.handler",
		"com.springboot.myapp.app.datasource"})
//注意这里扫包不能直接扫，com.springboot.myapp，否则
//启动报错 If you want an embedded database please put a supported one on the classpath

//@EnableTransactionManagement //spring事务：编程事务，声明事务（xml,注解配置）
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}


