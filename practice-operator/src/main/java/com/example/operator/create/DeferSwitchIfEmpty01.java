package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class DeferSwitchIfEmpty01 {

    public static void main(String[] args) throws InterruptedException {
        log.info("========== v1 ==========");
        Mono.just("Good morning! v1")
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(sayHello())
                .subscribe(result -> log.info("result v1(no defer) : {}", result));
        Thread.sleep(2500L);

        log.info("========== v2 ==========");
        Mono.just("Good morning! v2")
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(Mono.defer(DeferSwitchIfEmpty01::sayHello))
                .subscribe(result -> log.info("result v2(defer) : {}", result));
        Thread.sleep(2500L);

        log.info("========== v3 ==========");
        Mono.empty()
                .delayElement(Duration.ofSeconds(2L))
                .switchIfEmpty(Mono.defer(DeferSwitchIfEmpty01::sayHello))
                .subscribe(result -> log.info("result v3(empty + defer) : {}", result));
        Thread.sleep(2500L);
    }

    public static Mono<String> sayHello() {
        log.info("sayHello method called!");
        return Mono.just("Hello!");
    }

}
