package com.quest.demographics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemographicsApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemographicsApplication.class, args);
		logger.info("DemographicsApplication: Application started");
	}
}
