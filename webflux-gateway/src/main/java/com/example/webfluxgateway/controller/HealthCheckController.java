package com.example.webfluxgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthCheckController {

    @GetMapping("/ping")
    public Mono<String> checkPing() {
        return Mono.just("pong");
    }

}
