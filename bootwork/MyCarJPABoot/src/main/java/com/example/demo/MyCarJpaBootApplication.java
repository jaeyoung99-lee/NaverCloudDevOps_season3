package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"mycar.*","naver.storage"})
@EntityScan("mycar.data")
@EnableJpaRepositories("mycar.repository")
public class MyCarJpaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCarJpaBootApplication.class, args);
	}

}
