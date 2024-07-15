package com.example.store.dto.response;

import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreResponseDto(
        String storeName, String storeAddress, LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction,
        StoreCategory storeCategory
) {
    public static StoreResponseDto from(Store store) {
        return new StoreResponseDto(store.getStoreName(), store.getStoreAddress(), store.getStoreOpenAt(), store.getStoreCloseAt(), store.getStorePhone(), store.getStoreMinimumOrderAmount(), store.getStoreIntroduction(), store.getStoreCategory());
    }
}
