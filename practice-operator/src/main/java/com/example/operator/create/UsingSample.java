package com.example.operator.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class UsingSample {

    public static void main(String[] args) {
        Mono.using(
                () -> "Resource1",
                resource -> Mono.just("Resource2"),
                resource -> log.info("clean up!")
            )
            .subscribe(result -> log.info("result : {}", result));
    }

}
