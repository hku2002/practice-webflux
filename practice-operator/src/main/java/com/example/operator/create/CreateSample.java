package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class CreateSample {

    public static void main(String[] args) {
        Flux.create(sink -> {
            sink.next("result1");
            sink.next("result2");
            sink.complete();
        }).subscribe(result -> log.info("result : {}", result));
    }

}
