package com.example.flashcard.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class CircuitBreakerController {

    private static final Logger LOG = LoggerFactory.getLogger(CircuitBreakerController.class);

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/circuit-break")
    @CircuitBreaker(name = "circuitbreaker",fallbackMethod = "getCircuitError")
    public String circuitBreaker() throws Exception{
        LOG.info("Calling local method🐷🐷🐷🐷");
        String URL = "http://localhost:8080/book-service";
        String response = restTemplate.getForObject(URL, String.class);
        return response;
    }

    public String getCircuitError(Throwable throwable){
        LOG.warn("Called CircuitBreaker Method🧨🧨🧨");
        return "Something is wrong with book-service";
    }
}
