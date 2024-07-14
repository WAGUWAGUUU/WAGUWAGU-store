package com.example.store.dto.response;

import com.example.store.global.entity.StoreDeliveryInfo;

public record StoreDeliveryInfoResponseDto(
        int storeDeliveryInfoState,  int storeDeliveryInfoFee, Double storeDeliveryInfoDistanceEnd
) {
    public static StoreDeliveryInfoResponseDto from(StoreDeliveryInfo storeDeliveryInfo) {
        return new StoreDeliveryInfoResponseDto(storeDeliveryInfo.getStoreDeliveryInfoState(), storeDeliveryInfo.getStoreDeliveryInfoFee(), storeDeliveryInfo.getStoreDeliveryInfoDistanceEnd());
    }
}
