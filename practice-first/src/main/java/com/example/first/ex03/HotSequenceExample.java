package com.example.first.ex03;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Slf4j
public class HotSequenceExample {
    public static void main(String[] args) throws InterruptedException {
        Flux<String> hotFlux = Flux.fromStream(Stream.of("Singer A", "Singer B", "Singer C", "Singer D", "Singer E"))
                        .delayElements(Duration.ofSeconds(1)).share();

        hotFlux.subscribe(singer -> log.info("# Subscriber1: {}", singer));
        Thread.sleep(2500L);

        hotFlux.subscribe(singer -> log.info("# Subscriber2: {}", singer));
        Thread.sleep(3000L);
    }
}
