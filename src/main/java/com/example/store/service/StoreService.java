package com.example.store.service;

import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponse;
import com.example.store.global.type.UpdateStoreType;

import java.util.List;

public interface StoreService {
    void createStore(StoreRequestDto storeRequestDto);

    StoreResponse getStoreByStoreId(Long storeId);

    void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto);

    void deleteStore(Long storeId);

    List<StoreResponse> getAllStore();
}
