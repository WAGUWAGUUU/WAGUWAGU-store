package com.example.store.dto.response;

import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreResponseDto(
        String storeName, double storeAddressX, double storeAddressY, LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction,
        StoreCategory storeCategory
) {
    public static StoreResponseDto from(Store store) {
        return new StoreResponseDto(store.getStoreName(), store.getStoreAddressX(), store.getStoreAddressY(), store.getStoreOpenAt(), store.getStoreCloseAt(), store.getStorePhone(), store.getStoreMinimumOrderAmount(), store.getStoreIntroduction(), store.getStoreCategory());
    }
}
