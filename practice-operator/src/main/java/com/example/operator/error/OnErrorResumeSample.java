package com.example.operator.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class OnErrorResumeSample {

    public static void main(String[] args) {

        Book nodeBook = Book.builder()
                .id(1)
                .name(null)
                .price(10000)
                .build();
        Book javaBook = Book.builder()
                .id(1)
                .name("자바 바이블")
                .price(10000)
                .build();

        Mono
                .just(nodeBook)
                .map(data -> data.getName().toLowerCase())
                .onErrorResume(resume -> Mono.just(javaBook.getName().toLowerCase()))
                .subscribe(result -> log.info("result: {}", result));

    }

}
