package com.example.store.service;

import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.response.OwnerResponse;
import com.example.store.global.type.UpdateOwnerType;

import java.util.List;

public interface OwnerService {
    void createOwner(OwnerRequestDto ownerRequestDto);
    OwnerResponse getOwnerByOwnerId(Long ownerId);

    void updateOwner(Long ownerId, UpdateOwnerType updateOwnerType, UpdateOwnerRequestDto updateOwnerRequestDto);

    void deleteOwner(Long ownerId);

    List<OwnerResponse> getAllOwner();
}
