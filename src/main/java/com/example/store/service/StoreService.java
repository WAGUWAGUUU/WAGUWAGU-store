package com.example.store.service;

import com.example.store.dto.request.PhotoRequest;
import com.example.store.dto.request.StoreRequestDto;
import com.example.store.dto.request.StoreUpdateRequest;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.dto.response.StoreResponse;
import com.example.store.global.entity.Store;
import com.example.store.global.type.UpdateStoreType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StoreService {
    void createStore(StoreRequestDto storeRequestDto);

    StoreResponse getStoreByStoreId(Long storeId);

//    void updateStore(Long storeId, UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto);

    void updateStoreInfo(Long storeId, StoreUpdateRequest req);

    void deleteStore(Long storeId);

    List<StoreResponse> getAllStore();

    // ownerId 기준으로 storeId 가져오기
    StoreResponse getStoreByOwnerId(Long ownerId);

    void blockStoreIsOpened(Long storeId);

    boolean checkBlockStoreIsOpened(Long storeId);

    boolean checkStoreIsOpened(Long storeId);

//    void updateStorePhotoInfo(Long storeId, MultipartFile input) throws IOException;

    String getStorePhotoInfo(Long storeId);
}
