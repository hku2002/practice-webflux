package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class MapSample {

    public static void main(String[] args) {
        Flux.just("AA", "BB", "CC")
                .map(String::toLowerCase)
                .subscribe(result -> log.info("result: {}", result));
    }

}
