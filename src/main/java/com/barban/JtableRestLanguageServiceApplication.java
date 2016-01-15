package com.barban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@Import(RepositoryRestMvcConfiguration.class)
public class JtableRestLanguageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtableRestLanguageServiceApplication.class, args);
	}
}
