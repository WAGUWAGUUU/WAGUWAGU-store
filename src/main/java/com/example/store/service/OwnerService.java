package com.example.store.service;

import com.example.store.dto.request.OwnerRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.global.entity.Owner;
import com.example.store.global.type.UpdateOwnerType;

import java.util.List;

public interface OwnerService {
    void createOwner(OwnerRequestDto ownerRequestDto);
    Owner getOwnerByOwnerId(Long ownerId);

    void updateOwner(Long ownerId, UpdateOwnerType updateOwnerType, UpdateOwnerRequestDto updateOwnerRequestDto);

    void deleteOwner(Long ownerId);

    List<Owner> getAllOwner();
}
