package com.rediscache.rediscachetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class RedisCacheTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheTestApplication.class, args);
	}
}
