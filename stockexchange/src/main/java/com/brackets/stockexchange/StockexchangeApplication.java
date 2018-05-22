package com.brackets.stockexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("com.brackets.stockexchange.controller")
public class StockexchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockexchangeApplication.class, args);
	}
}
