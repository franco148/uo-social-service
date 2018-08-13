package com.umssonline.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.umssonline.social.feign"})
@EnableCircuitBreaker
@SpringBootApplication
public class SocialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialServiceApplication.class, args);
	}
}
