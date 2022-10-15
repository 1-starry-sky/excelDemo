package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@MapperScan("com.example.mapper.PrivateCalculationMapper")     --启动失败
@SpringBootApplication(scanBasePackages = {"com.example"})
@MapperScan("com.example")
public class WebControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebControllerApplication.class, args);
	}

}
