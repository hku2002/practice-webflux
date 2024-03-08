package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class DeferSwitchIfEmpty01 {

    public static void main(String[] args) throws InterruptedException {
        log.info("========== v1 ==========");
        Mono<String> monoV1 = Mono.just("Good morning! v1")
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(sayHello());
        Thread.sleep(2500L);
        monoV1.subscribe(result -> {
            log.info("result : {}", result);
            log.info("========== v2 ==========");
        });

        Mono<String> monoV2 = Mono.just("Good morning! v2")
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(Mono.defer(DeferSwitchIfEmpty01::sayHello));
        Thread.sleep(2500L);
        monoV2.subscribe(result -> {
            log.info("result : {}", result);
            log.info("========== v3 ==========");
        });

        Mono<Object> monoV3 = Mono.empty()
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(Mono.defer(DeferSwitchIfEmpty01::sayHello));
        Thread.sleep(2500L);
        monoV3.subscribe(result -> log.info("result : {}", result));
    }

    public static Mono<String> sayHello() {
        log.info("sayHello method called!");
        return Mono.just("Hello!");
    }

}
