package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ConcatSample {

    public static void main(String[] args) {
        Flux.concat(
                Flux.just("A", "B"),
                Flux.just("C", "D")
        )
                .subscribe(result -> log.info("result: {}", result));
    }

}
