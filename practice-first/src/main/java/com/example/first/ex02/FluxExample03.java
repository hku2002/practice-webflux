package com.example.first.ex02;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FluxExample03 {

    /**
     * 2개의 Mono 를 연결해서 Flux 로 변환하는 예제
     */
    public static void main(String[] args) {
        Flux<Object> flux = Mono.justOrEmpty(null)
                .concatWith(Mono.justOrEmpty("jobs"));
        flux.subscribe(consumer -> log.info("# consumer: {}", consumer));
    }
}
