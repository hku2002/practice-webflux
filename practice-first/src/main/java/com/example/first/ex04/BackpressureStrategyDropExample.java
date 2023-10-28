package com.example.first.ex04;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class BackpressureStrategyDropExample {

    /*
     * Backpressure Drop 전략
     * -> 버퍼가 가득 찼을 때 버퍼 밖에서 대기하는 먼저 emit 된 데이터를 Drop 하는 전략
     */
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureDrop(dropped -> log.info("dropped: {}", dropped))
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
