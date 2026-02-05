package com.newcampvex.newcampvex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class NewcampvexApplication {
	public static void main(String[] args) {
		SpringApplication.run(NewcampvexApplication.class, args);
	}
}
