package com.miura.twittersimplified;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Twitter Simplified", version = "0.0.1", description = "Api para teste de consumo"))
public class TwitterSimplifiedApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterSimplifiedApplication.class, args);
	}

}
