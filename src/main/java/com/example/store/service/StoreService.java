package com.example.store.service;

import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponseDto;
import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;

import java.util.List;

public interface StoreService {
    void createStore(StoreRequestDto storeRequestDto);

    StoreResponseDto getStoreByStoreId(Long storeId);

    void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto);

    void deleteStore(Long storeId);

    List<StoreResponseDto> getAllStore();
}
