package com.example.webfluxgateway.service.storedisplay;

import com.example.webfluxgateway.dto.HomeResponseDto;
import com.example.webfluxgateway.infra.client.storedisplay.StoreDisplayClient;
import com.example.webfluxgateway.infra.client.user.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final StoreDisplayClient storeDisplayClient;
    private final UserClient userClient;

    public Mono<HomeResponseDto> getDisplayStore(int id, int userId) {
        return userClient.requestAddress(userId)
                .flatMap(address -> storeDisplayClient
                        .requestStores(id)
                        .collectList()
                        .map(storeDisplay -> HomeResponseDto.builder()
                                .addressResponseDto(address)
                                .displayStoreResponseDto(storeDisplay)
                                .build()));
    }

}
