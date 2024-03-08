package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class GenerateSample {

    public static void main(String[] args) {

        Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next(state);
                    if (state == 10) {
                        log.info("state is 10. sink completed!");
                        sink.complete();
                    }
                    return ++state;
                }
        )
                .subscribe(result -> log.info("result : {}", result));

    }

}
