package com.example.store.dto.request;

import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreUpdateRequest(
        String storeName,
        String storeAddress,
        LocalTime storeOpenAt,
        LocalTime storeCloseAt,
        String storePhone,
        int storeMinimumOrderAmount,
        String storeIntroduction,
        StoreCategory storeCategory,
        double storeLongitude,
        double storeLatitude
) {
}
