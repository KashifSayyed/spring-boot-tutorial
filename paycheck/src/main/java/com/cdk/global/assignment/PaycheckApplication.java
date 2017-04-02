package com.cdk.global.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PaycheckApplication {
	private static final Logger log = LoggerFactory.getLogger(PaycheckApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PaycheckApplication.class, args);
		log.info("PayCheck Application Started...");
	}
}
