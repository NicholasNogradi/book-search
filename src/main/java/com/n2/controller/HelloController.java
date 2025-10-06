package com.n2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Greeting", description = "Endpoints that return simple greetings")
@RestController
public class HelloController {
    @Operation(summary = "Say hello", description = "Returns a simple greeting message")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successful greeting")
    })
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
