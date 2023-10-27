package com.example.first.ex05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class BackpressureStrategyErrorExample {

    /*
     * Backpressure Error 전략
     * -> 버퍼가 가득 찼을 때 Exception 발생하는 전략
     */
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureError()
                .doOnNext(onNext -> log.info("doOnNext: {}", onNext))
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    log.info("onNext: {}", data);
                }, error -> log.info("onError: {}", error));

        Thread.sleep(2000L);
    }
}
