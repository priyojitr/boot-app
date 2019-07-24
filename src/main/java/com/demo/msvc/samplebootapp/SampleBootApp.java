package com.demo.msvc.samplebootapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleBootApp {

	private static final Logger log = LoggerFactory.getLogger(SampleBootApp.class);

	public static void main(String[] args) {
		log.info("application started");
		SpringApplication.run(SampleBootApp.class, args);

	}

}
