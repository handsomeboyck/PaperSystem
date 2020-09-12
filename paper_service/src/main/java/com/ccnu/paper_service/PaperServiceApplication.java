package com.ccnu.paper_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ccnu.paper_service.mapper")
public class PaperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperServiceApplication.class, args);
	}

}
