package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
public class DeferSample {

    public static void main(String[] args) throws InterruptedException {
        log.info("main started!");

        Mono<LocalDateTime> justMono = Mono.just(LocalDateTime.now());
        Mono<LocalDateTime> deferMono = Mono.defer(() -> Mono.just(LocalDateTime.now()));

        Thread.sleep(2000);

        justMono.subscribe(just -> log.info("justMono1 : {}", just));
        deferMono.subscribe(defer -> log.info("deferMono1 : {}", defer));

        Thread.sleep(2000);

        justMono.subscribe(just -> log.info("justMono2 : {}", just));
        deferMono.subscribe(defer -> log.info("deferMono2 : {}", defer));

    }

}
