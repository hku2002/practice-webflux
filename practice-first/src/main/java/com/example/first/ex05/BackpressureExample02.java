package com.example.first.ex05;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class BackpressureExample02 {
    public static int count = 0;
    public static void main(String[] args) {
        Flux.range(1, 5)
                .doOnNext(onNext -> log.info("doOnNext : {}", onNext))
                .doOnRequest(consumer -> log.info("doOnRequest : {}", consumer))
                .subscribe(new BaseSubscriber<>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(2);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        count++;
                        log.info("onNext : {}", value);
                        if (count == 2) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            request(2);
                            count = 0;
                        }
                    }
                });
    }
}
