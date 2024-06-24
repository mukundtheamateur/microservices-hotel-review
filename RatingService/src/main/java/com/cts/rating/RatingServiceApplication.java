package com.cts.rating;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		log.info("Inside main of RatingServiceApplication");
		SpringApplication.run(RatingServiceApplication.class, args);
		log.info("#####################End of main of RatingServiceApplication####################");
	}

}
