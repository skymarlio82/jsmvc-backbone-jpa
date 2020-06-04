
package com.spa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.spa.demo.service.EventService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EventService eventService = null;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		System.out.println("java.io.tmpdir = " + System.getProperty("java.io.tmpdir"));
		return args -> {
			eventService.initData();
		};
	}
}