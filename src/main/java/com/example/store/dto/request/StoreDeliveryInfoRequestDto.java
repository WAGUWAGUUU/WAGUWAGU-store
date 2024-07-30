package com.example.store.dto.request;

import com.example.store.global.entity.Store;
import com.example.store.global.entity.StoreDeliveryInfo;

public record StoreDeliveryInfoRequestDto(
        int storeDeliveryInfoState, int storeDeliveryInfoFee, double storeDeliveryInfoDistanceEnd
) {
    public StoreDeliveryInfo toEntity(Store store) {
        return StoreDeliveryInfo.builder()
                .storeDeliveryInfoState(storeDeliveryInfoState)
                .storeDeliveryInfoFee(storeDeliveryInfoFee)
                .storeDeliveryInfoDistanceEnd(storeDeliveryInfoDistanceEnd)
                .store(store)
                .build();
    }
}
