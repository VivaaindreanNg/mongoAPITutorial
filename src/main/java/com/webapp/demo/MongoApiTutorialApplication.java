package com.webapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableAutoConfiguration
@ComponentScan({"com.webapp"})
@EnableMongoRepositories("com.webapp.repository")
@SpringBootApplication
public class MongoApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoApiTutorialApplication.class, args);
	}

}
