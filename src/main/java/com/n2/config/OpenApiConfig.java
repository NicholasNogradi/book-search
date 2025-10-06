package com.n2.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Book Search API",
        version = "1.0.1",
        description = "API for importing and searching books",
        contact = @Contact(name = "Nicholas Nogradi", email = "nicholas@example.com")
    ),
    servers = {
        @Server(url = "/", description = "Default server")
    }
)
@Configuration
public class OpenApiConfig {
    // intentionally empty - metadata is provided via annotations
}
