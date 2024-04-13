package com.doding.ditest;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DitestApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			log.debug("optional: {}", args.getOptionNames());
			log.debug("non optional: {}", args.getNonOptionArgs());
		};
	}

}
