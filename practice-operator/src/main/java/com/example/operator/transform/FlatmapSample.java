package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FlatmapSample {

    public static void main(String[] args) {
        Flux.just("A", "B", "C")
                .flatMap(alphabet ->
                        Flux.just("Hello", "World")
                                .map(data -> alphabet + ": " + data)
                )
                .subscribe(result -> log.info("result: {}", result));
    }

}
