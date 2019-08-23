
package com.spa.demo.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.spa.demo.mvc.domain.service.EventService;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.spa.demo.mvc")
@EnableJpaRepositories("com.spa.demo.mvc.data.dao")
public class Application {

	private static final Class<Application> applicationClass = Application.class;

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
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