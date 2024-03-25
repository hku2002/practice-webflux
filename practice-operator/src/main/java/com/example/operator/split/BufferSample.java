package com.example.operator.split;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class BufferSample {

    public static void main(String[] args) {
        Flux
                .range(1, 32)
                .buffer(10)
                .subscribe(result -> log.info("result: {}", result));

    }

}
