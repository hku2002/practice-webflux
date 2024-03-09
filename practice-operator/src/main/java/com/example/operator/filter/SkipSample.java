package com.example.operator.filter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class SkipSample {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1L))
                .doOnNext(data -> log.info("data: {}", data))
                .skip(3L)
                .subscribe(result -> log.info("result1: {}", result));

        Thread.sleep(5000L);

        Flux.interval(Duration.ofSeconds(1L))
                .skip(Duration.ofSeconds(3L))
                .subscribe(result -> log.info("result2: {}", result));

        Thread.sleep(5000L);
    }

}
