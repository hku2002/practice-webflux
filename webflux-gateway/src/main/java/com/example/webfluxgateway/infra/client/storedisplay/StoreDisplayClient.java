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
    private final String storeDisplayBaseUrl = "http://localhost:8080";

    public StoreDisplayClient(WebClient webClient) {
        this.webClient = webClient
                .mutate()
                .baseUrl(storeDisplayBaseUrl)
                .build();
    }

    public Flux<DisplayStoreResponseDto> requestStores() {
        return webClient.method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path(storeDisplayBaseUrl)
                        .queryParam("id", String.valueOf(1))
                        .build())
                .retrieve()
                .bodyToFlux(DisplayStoreResponseDto.class)
                .timeout(Duration.ofMillis(3000L));
    }

}
