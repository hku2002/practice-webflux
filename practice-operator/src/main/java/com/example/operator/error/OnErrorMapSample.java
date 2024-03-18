package com.example.operator.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class OnErrorMapSample {

    public static void main(String[] args) {

        Book nodeBook = Book.builder()
                .id(1)
                .name(null)
                .price(10000)
                .build();
        Book javaBook = Book.builder()
                .id(2)
                .name("자바의 신")
                .price(20000)
                .build();

        Flux
                .just(nodeBook, javaBook)
                .map(data -> data.getName().toLowerCase())
                .onErrorMap(NullPointerException.class, errorMap -> new IllegalStateException("책 제목이 없습니다."))
                .subscribe(result -> log.info("result: {}", result));
    }

}
