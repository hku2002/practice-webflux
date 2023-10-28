package com.example.first.ex05;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ParallelExample01 {

    /*
     * parallel() 연산자를 사용하여 병렬로 작업 수행하는 예제
     * parallel() 만 사용하면 병렬 실행되지 않고 runOn() 연산자를 활용하여 Scheduler 를 할당해주어야 병렬로 작업을 수행한다.
     * 스레드 수는 CPU 코어의 논리 프로세서 수를 따라간다. (일반적으로 core * 2)
     * parallel() 연산자 인수에 2를 넣으면 2개 스레드만 사용한다. (논리 프로세서 갯수 이상을 넣어도 최대값은 논리 프로세스 갯수 이다)
     */
    public static void main(String[] args) throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11})
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(onNext -> log.info("# onNext: {}", onNext));

        /* 다른 스레드에서 발생하는 로그를 보기 위한 sleep */
        Thread.sleep(1000L);
    }
}
