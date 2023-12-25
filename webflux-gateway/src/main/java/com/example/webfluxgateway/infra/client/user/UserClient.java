package com.example.webfluxgateway.infra.client.user;

import com.example.webfluxgateway.dto.AddressResponseDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class UserClient {

    private final WebClient webClient;
    private final String userBaseUrl = "http://localhost:8090";

    public UserClient(WebClient webClient) {
        this.webClient = webClient
                .mutate()
                .baseUrl(userBaseUrl)
                .build();
    }

    public Mono<AddressResponseDto> requestAddress(int userId) {
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path(userBaseUrl)
                        .queryParam("userId", String.valueOf(userId))
                        .build())
                .retrieve()
                .bodyToMono(AddressResponseDto.class)
                .timeout(Duration.ofMillis(3000L));
    }

}
