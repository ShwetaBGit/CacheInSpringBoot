package com.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InMemoryCacheSpringBootAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMemoryCacheSpringBootAppApplication.class, args);
	}

}
