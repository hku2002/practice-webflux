package com.example.webfluxgateway.controller;

import com.example.webfluxgateway.dto.HomeResponseDto;
import com.example.webfluxgateway.service.storedisplay.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @RequestMapping("/home/display/{id}/users/{userId}")
    public Mono<HomeResponseDto> getHomeItems(@PathVariable int id, @PathVariable int userId) {
        return homeService.getDisplayStore(id, userId);
    }

}
