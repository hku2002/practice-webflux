package com.example.webfluxgateway.service.storedisplay;

import com.example.webfluxgateway.dto.DisplayStoreResponseDto;
import com.example.webfluxgateway.infra.client.storedisplay.StoreDisplayClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final StoreDisplayClient storeDisplayClient;

    public Mono<List<DisplayStoreResponseDto>> getDisplayStore(int id) {
        return storeDisplayClient.requestStores(id).collectList();
    }

}
