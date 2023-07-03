package com.jovscv.springdatajpaexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = {"com.jovscv.springdatajpaexercise"})
@EntityScan("com.jovscv.springdatajpaexercise.model")
public class SpringdatajpaExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaExerciseApplication.class, args);
	}

}
