package com.example.first.ex06;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

@Slf4j
public class DebugModeExample02 {

    /**
     * 디버그 모드 사용인 경우
     */
    public static void main(String[] args) {
        Hooks.onOperatorDebug();
        Flux.just(2, 4, 6, 8)
                .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x / y)
                .subscribe(
                        consumer -> log.info("onNext : {}", consumer),
                        error -> log.error("onError : {}", error)
                );
    }
}
