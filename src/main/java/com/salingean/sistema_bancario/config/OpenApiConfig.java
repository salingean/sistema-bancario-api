package com.salingean.sistema_bancario.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAI() {
        return new OpenAPI()
        .info(
                new Info()
                        .title("Banking System API")
                        .version("1.0")
                        .description("REST API for managing bank accounts and financial transfers.")
                        .contact(
                                new Contact()
                                        .name("Salin Gean")
                                        .email("salingeanestrela@gmail.com")
                        )
        );
    }
}
