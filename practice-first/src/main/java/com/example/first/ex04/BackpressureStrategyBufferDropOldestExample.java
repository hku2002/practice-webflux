package com.example.first.ex04;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@Slf4j
public class BackpressureStrategyBufferDropOldestExample {

    /*
     * Backpressure Buffer Latest 전략
     * -> 버퍼가 가득 찼을 때 버퍼 안에서 가장 오래된(Oldest) 버퍼로 들어온 데이터부터 Drop 하는 전략
     */
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(300L))
                .doOnNext(emit -> log.info("emitted: {}", emit))
                .onBackpressureBuffer(
                        2,
                        dropped -> log.info("Overflow & dropped: {}", dropped),
                        BufferOverflowStrategy.DROP_OLDEST
                )
                .doOnNext(onNext -> log.info("doOnNext: {}", onNext))
                .publishOn(
                        Schedulers.parallel(),
                        false,
                        1
                )
                .subscribe(data -> {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    log.info("onNext: {}", data);
                }, error -> log.info("onError: {}", error));

        Thread.sleep(3000L);
    }
}
