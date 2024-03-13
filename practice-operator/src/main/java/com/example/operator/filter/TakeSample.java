package com.example.operator.filter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class TakeSample {

    public static void main(String[] args) throws InterruptedException {
        Flux.range(0, 10)
                .take(3L)
                .subscribe(result -> log.info("result : {}", result));

        Flux.interval(Duration.ofSeconds(1L))
                .take(Duration.ofSeconds(3L))
                .subscribe(result -> log.info("result : {}", result));

        Thread.sleep(5000L);
    }

}
