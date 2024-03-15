package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ZipSample {

    public static void main(String[] args) {
        Flux.zip(
                Flux.just(1, 2, 3, 4),
                Flux.just("A", "B", "C")
        )
                .subscribe(result -> log.info("result: {}", result));
    }

}
