package com.example.first.ex02;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FluxExample04 {

    /**
     * 여러개의 Flux 를 연결해서 하나의 Flux 로 연결하는 예제
     */
    public static void main(String[] args) {
        Flux.concat(
                Flux.just("Martin"),
                Flux.just("Adam"),
                Flux.just("Connie"))
            .collectList()
            .subscribe(consumer -> log.info("# names: {}", consumer));

    }
}
