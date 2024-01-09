package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"myshop.*","naver.storage"})
@MapperScan("myshop.mapper")
public class MyShopMybatisBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyShopMybatisBootApplication.class, args);
	}

}
