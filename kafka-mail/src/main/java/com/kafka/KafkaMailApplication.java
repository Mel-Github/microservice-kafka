package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class KafkaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMailApplication.class, args);
	}

}
