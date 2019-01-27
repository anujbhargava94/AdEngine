package com.anuj.project.flipkartTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.anuj.project.flipkartTest")
public class FlipkartTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipkartTestApplication.class, args);
	}

}
