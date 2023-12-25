package com.example.webfluxgateway.controller;

import com.example.webfluxgateway.dto.DisplayStoreResponseDto;
import com.example.webfluxgateway.service.storedisplay.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @RequestMapping("/home/display/{id}")
    public Mono<List<DisplayStoreResponseDto>> getHomeItems(@PathVariable int id) {
        return homeService.getDisplayStore(id);
    }

}
