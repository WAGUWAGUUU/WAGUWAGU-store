package com.example.store.service;

import com.example.store.dto.request.StoreDeliveryInfoRequestDto;
import com.example.store.dto.request.UpdateStoreDeliveryInfoRequestDto;
import com.example.store.dto.response.StoreDeliveryInfoResponseDto;
import com.example.store.global.type.UpdateStoreDeliveryInfoType;
import com.example.store.global.type.UpdateStoreType;

import java.util.List;

public interface StoreDeliveryInfoService {
    void createStoreDeliveryInfo(Long storeId, StoreDeliveryInfoRequestDto storeDeliveryInfoRequestDto);

    List<StoreDeliveryInfoResponseDto>  getStoreDeliveryInfoAllByStoreId(Long storeId);

    void updateStoreDeliveryInfoByStoreIdAndState(Long storeId, int storeDeliveryInfoState, UpdateStoreDeliveryInfoType updateStoreDeliveryInfoType, UpdateStoreDeliveryInfoRequestDto updateStoreDeliveryInfoRequestDto);
}
