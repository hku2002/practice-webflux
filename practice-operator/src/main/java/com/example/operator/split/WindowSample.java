package com.example.operator.split;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class WindowSample {

    public static void main(String[] args) {

        Flux
                .range(1, 11)
                .window(3)
                .flatMap(flux -> {
                    log.info("==========");
                    return flux;
                })
                .subscribe(new BaseSubscriber<>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        subscription.request(2L);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        log.info("value: {}", value);
                        request(2L);
                    }
                });

    }

}
