package com.example.first.stepverifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class StepVerifierExampleTest {

    @Test
    @DisplayName("(Mono) Hello Reactor 방출이 올바르게 되었는지 확인")
    void sayHelloReactorMonoTest() {
        StepVerifier
                .create(Mono.just("Hello Reactor"))
                .expectNext("Hello Reactor")
                .expectComplete()
                .verify();
    }

    @Test
    @DisplayName("(Flux) Hello Reactor 방출이 올바르게 되었는지 확인")
    void sayHelloReactorFluxTest() {
        StepVerifier
                .create(Flux.just("Hello", "Reactor"))
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .expectComplete()
                .verify();
    }

    @Test
    @DisplayName("(Flux) Hello Reactor 방출이 올바르게 되었는지 확인")
    void sayHelloReactorFluxWithDescriptionTest() {
        StepVerifier
                .create(Flux.just("Hello", "Reactor"))
                .expectSubscription()
                .as("expect subscription")
                .expectNext("Hi")
                .as("expect Hi") // Hi 라는 값이 없으므로 expect Hi 를 출력, 테스트는 실패
                .expectNext("Reactor")
                .as("expect Reactor")
                .verifyComplete();
    }
}
