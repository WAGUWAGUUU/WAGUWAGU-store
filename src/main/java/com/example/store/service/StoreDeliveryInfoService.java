package com.example.store.service;

import com.example.store.dto.request.StoreDeliveryInfoRequestDto;
import com.example.store.dto.request.UpdateStoreDeliveryInfoRequestDto;
import com.example.store.dto.response.StoreDeliveryInfoResponse;
import com.example.store.global.type.UpdateStoreDeliveryInfoType;

import java.util.List;

public interface StoreDeliveryInfoService {
    void createStoreDeliveryInfo(Long storeId, StoreDeliveryInfoRequestDto storeDeliveryInfoRequestDto);

    List<StoreDeliveryInfoResponse>  getStoreDeliveryInfoAllByStoreId(Long storeId);

    void updateStoreDeliveryInfoByStoreIdAndState(Long storeId, int storeDeliveryInfoState, UpdateStoreDeliveryInfoType updateStoreDeliveryInfoType, UpdateStoreDeliveryInfoRequestDto updateStoreDeliveryInfoRequestDto);
}
