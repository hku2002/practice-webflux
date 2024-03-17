package com.example.operator.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorSample {

    public static void main(String[] args) {
        Flux
                .range(0, 10)
                .flatMap(data -> Mono.error(new IllegalStateException("Illegal state!")))
                .subscribe(result -> log.info("result: {}", result));
    }

}
