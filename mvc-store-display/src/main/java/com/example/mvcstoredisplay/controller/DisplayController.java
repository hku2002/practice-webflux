package com.example.mvcstoredisplay.controller;

import com.example.mvcstoredisplay.dto.DisplayStoreResponseDto;
import com.example.mvcstoredisplay.service.DisplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DisplayController {

    private final DisplayService displayService;

    @GetMapping("/display/stores")
    public List<DisplayStoreResponseDto> getStores() {
        return displayService.getStores();
    }

}
