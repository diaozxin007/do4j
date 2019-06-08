package com.xilidou.do4j;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
