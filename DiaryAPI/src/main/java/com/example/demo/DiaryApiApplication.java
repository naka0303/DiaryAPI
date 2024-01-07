package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.demo.domain")
@MapperScan("com.example.demo.mapper")
@ComponentScan
public class DiaryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiaryApiApplication.class, args);
	}

}
