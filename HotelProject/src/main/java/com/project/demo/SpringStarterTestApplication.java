package com.project.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.project.controller")
@ComponentScan("com.project.service")
@ComponentScan("com.project.config")
@MapperScan("com.project.dao")
@ComponentScan("com.project.shiro")
@EnableCaching  //开启缓存
public class SpringStarterTestApplication {

	//1212
	public static void main(String[] args) {
		SpringApplication.run(SpringStarterTestApplication.class, args);
	}

}
