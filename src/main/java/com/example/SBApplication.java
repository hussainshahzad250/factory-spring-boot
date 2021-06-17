package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Shahzad Hussain
 */
@EnableCaching
@SpringBootApplication
@ComponentScan(basePackages = { "com.*" })
public class SBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBApplication.class, args);
	}

}
