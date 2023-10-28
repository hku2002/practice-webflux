package com.example.first.ex04;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class BackpressureExample01 {
    public static void main(String[] args) {
        Flux.range(1, 5)
                .doOnNext(onNext -> log.info("doOnNext : {}", onNext))
                .doOnRequest(consumer -> log.info("doOnRequest : {}", consumer))
                .subscribe(new BaseSubscriber<>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        log.info("onNext : {}", value);
                        request(1);
                    }
                });
    }
}
