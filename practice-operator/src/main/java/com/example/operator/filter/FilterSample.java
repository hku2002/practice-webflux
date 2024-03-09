package com.example.operator.filter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FilterSample {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(0, 10)
                .filter(data -> (data % 2) > 0)
                .subscribe(result -> log.info("result: {}", result));
    }
}
