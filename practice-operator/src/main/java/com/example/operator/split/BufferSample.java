package com.example.operator.split;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class BufferSample {

    public static void main(String[] args) {
        Flux
                .range(1, 32)
                .buffer(10)
                .subscribe(result -> log.info("result: {}", result));


        Flux
                .range(1, 20)
                .mapNotNull(num -> {
                    try {
                        if (num < 10) {
                            Thread.sleep(100L);
                        } else {
                            Thread.sleep(300L);
                        }
                    } catch (Exception e) {
                        log.error("exception: ", e);
                    }
                    return num;
                })
                .bufferTimeout(3, Duration.ofMillis(400L))
                .subscribe(result -> log.info("result: {}", result));
    }

}
