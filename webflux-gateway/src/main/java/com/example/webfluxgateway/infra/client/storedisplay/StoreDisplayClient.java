package com.example.webfluxgateway.infra.client.storedisplay;

import com.example.webfluxgateway.dto.DisplayStoreResponseDto;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class StoreDisplayClient {

    private final WebClient webClient;

    public StoreDisplayClient(WebClient webClient) {
        this.webClient = webClient
                .mutate()
                .baseUrl("http://store-display-service:8080")
                .build();
    }

    public Flux<DisplayStoreResponseDto> requestHomeStores() {
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path("/display/stores")
                        .build())
                .retrieve()
                .bodyToFlux(DisplayStoreResponseDto.class)
                .timeout(Duration.ofMillis(3000L));
    }

}
