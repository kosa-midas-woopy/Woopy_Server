package com.indoor.woopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class WoopyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WoopyApplication.class, args);
	}

}
