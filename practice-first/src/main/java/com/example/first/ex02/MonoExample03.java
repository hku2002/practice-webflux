package com.example.first.ex02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

@Slf4j
public class MonoExample03 {

    /**
     * worldtimeapi.org 의 Open API를 이용해서 서울의 현재 시간을 조회하는 예제
     */
    public static void main(String[] args) {
        URI worldTimeUrl = UriComponentsBuilder.newInstance().scheme("https")
                .host("worldtimeapi.org")
                .port(443)
                .path("/api/timezone/Asia/Seoul")
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono.just(
                restTemplate.exchange(worldTimeUrl, HttpMethod.GET, new HttpEntity<String>(headers), String.class)
        )
                .map(String::valueOf)
                .subscribe(
                        consumer -> log.info("# emitted data: {}", consumer),
                        errorConsumer -> log.info("error: ", errorConsumer),
                        () -> log.info("# emitted onComplete signal")
                );

    }
}
