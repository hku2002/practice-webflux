package com.example.operator.transform;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FlatMapSample {

    public static void main(String[] args) {
        Flux.just("A", "B", "C")
                .flatMap(alphabet ->
                        Flux.just("Hello", "World")
                                .map(data -> alphabet + ": " + data)
                )
                .subscribe(result -> log.info("result: {}", result));

        Flux.just(1)
                .flatMap(num ->
                        Flux.range(0, 5)
                                .map(data -> num + data))
                .subscribe(result -> log.info("result: {}", result));

        String[][] strArr = {{"AA", "BB", "CC"}, {"DD", "EE", "FF"}};
        Flux.just(strArr)
                .flatMap(Flux::fromArray)
                .map(String::toLowerCase)
                .subscribe(result -> log.info("result: {}" , result));

        Flux.just(100, 200, 300)
                .flatMap(FlatMapSample::addTen)
                .subscribe(result -> log.info("result: {}", result));
    }


    private static Mono<Integer> addTen(int param) {
        return Mono
                .just(param)
                .map(data -> data + 10);
    }

}
