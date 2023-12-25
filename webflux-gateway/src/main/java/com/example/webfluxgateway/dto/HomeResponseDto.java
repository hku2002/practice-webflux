package com.example.webfluxgateway.dto;

import lombok.Builder;

import java.util.List;

public record HomeResponseDto(AddressResponseDto addressResponseDto, List<DisplayStoreResponseDto> displayStoreResponseDto) {
    @Builder
    public HomeResponseDto {
    }
}
