package com.example.first.ex05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class BackpressureStrategyLatestExample {

    /*
     * Backpressure Latest 전략
     * -> 버퍼가 가득 찼을 때 버퍼 밖에서 대기하는 먼저 나중에(Latest) emit 된 데이터부터 버퍼에 채우는 전략
     */
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureLatest()
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
