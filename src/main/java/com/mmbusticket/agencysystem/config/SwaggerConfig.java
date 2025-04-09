package com.mmbusticket.agencysystem.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				 .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
			        .components(new Components()
			            .addSecuritySchemes("bearerAuth",
			                new SecurityScheme()
			                    .name("Authorization")
			                    .type(SecurityScheme.Type.HTTP)
			                    .scheme("bearer")
			                    .bearerFormat("JWT")
			            )
			        )
				.addServersItem(new Server().url("http://localhost:8080").description("Local server"))
				.addServersItem(new Server().url("https://localhost:8080").description("Production server"))

				.info(new Info().title("MM Bus Ticket API").version("1.0.0")
						.description("API documentation for MM Bus Ticket Agency System")
						.contact(new Contact().name("Support Mama team").email("winminachawlay@gmail.com")
								.url("https://winTeam.com")));
	}
}
