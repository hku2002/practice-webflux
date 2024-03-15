package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class MergeSample {

    public static void main(String[] args) throws InterruptedException {
        Flux.merge(
                Flux
                        .just(1, 2, 3)
                        .delayElements(Duration.ofMillis(300L)),
                Flux
                        .just(4, 5, 6)
                        .delayElements(Duration.ofMillis(500L))
        )
                .subscribe(result -> log.info("result: {}", result));

        Thread.sleep(2000L);
    }

}
