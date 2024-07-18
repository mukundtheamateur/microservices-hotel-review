package com.cts.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class RatingServiceApplication {

	public static void main(String[] args) {
		log.info("Inside main of RatingServiceApplication");
		SpringApplication.run(RatingServiceApplication.class, args);
		log.info("#####################End of main of RatingServiceApplication####################");
	}

}
