package com.example.operator.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class OnErrorReturnSample {

    public static void main(String[] args) {
        Book book = Book.builder()
                .id(1)
                .name(null)
                .price(10000)
                .build();

        /*
         * onErrorReturn은 대체값을 전달함
         */
        Mono
                .just(book)
                .map(data -> data.getName().toLowerCase())
                .onErrorReturn("자바 바이블")
                .subscribe(result -> log.info("result: {}", result));
    }

}
