package com.example.first.ex03;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class ColdSequenceExample {
    public static void main(String[] args) {
        Flux<String> coldFlux = Flux.fromIterable(List.of("RED", "YELLOW", "PINK"))
                .map(String::toLowerCase);

        coldFlux.subscribe(consumer -> log.info("# Subscriber1: {}", consumer));
        log.info("=====================");
        coldFlux.subscribe(consumer -> log.info("# Subscriber2: {}", consumer));
    }
}
