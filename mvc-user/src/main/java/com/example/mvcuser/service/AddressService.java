package com.example.mvcuser.service;

import com.example.mvcuser.domain.repository.DeliveryAddressRepository;
import com.example.mvcuser.dto.AddressResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public AddressResponseDto getDefaultAddress(Long id) {
        return AddressResponseDto.createInstance(deliveryAddressRepository.findByIdAndIsDefault(id, true));
    }
}
