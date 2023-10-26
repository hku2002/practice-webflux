package com.example.first.ex01;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Ex01Test {
    public static void main(String[] args) {
        /* Flux.just("Hello", "Reactor") 에서 Flux 는 생산자
         * "Hello", "Reactor" 는 데이터 소스
         * .just() 는 시퀀스
         */
        Flux<String> sequence = Flux.just("Hello", "Reactor");

        /* 아래 코드에서 log::info 부분이 소비자
         * .map() 은 연산자
         */
        sequence.map(String::toLowerCase)
                .subscribe(log::info);
    }
}
