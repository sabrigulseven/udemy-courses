package com.sabrigulseven.houseapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class HouseapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseapiApplication.class, args);
	}

	@Bean
	public OpenAPI custOpenAPI(@Value("${application-description}") String description,
			@Value("${application-version}") String version) {
				return new OpenAPI()
						.info(new Info()
						.title("House Prices API")
						.version(version)
						.description(description)
						.license(new License().name("House Prices API Licence")));
				
	}
}
