package com.example.store.dto.response;

import com.example.store.global.entity.StoreDeliveryInfo;

public record StoreDeliveryInfoResponse(
        int storeDeliveryInfoState,  int storeDeliveryInfoFee, double storeDeliveryInfoDistanceEnd
) {
    public static StoreDeliveryInfoResponse from(StoreDeliveryInfo storeDeliveryInfo) {
        return new StoreDeliveryInfoResponse(storeDeliveryInfo.getStoreDeliveryInfoState(), storeDeliveryInfo.getStoreDeliveryInfoFee(), storeDeliveryInfo.getStoreDeliveryInfoDistanceEnd());
    }
}
