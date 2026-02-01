package com.rajanayak.pkms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class PkmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PkmsApplication.class, args);
	}

}
