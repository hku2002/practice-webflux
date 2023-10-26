package com.example.first;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class HelloReactor {
    public static void main(String[] args) {
        Mono.just("Hello reactor")
                .subscribe(message -> log.info("Hello Reactor!"));
    }
}
