package com.example.store.dto.response;

import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreResponse(
        String storeName, double storeAddressX, double storeAddressY, LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction,
        StoreCategory storeCategory
) {
    public static StoreResponse from(Store store) {
        return new StoreResponse(store.getStoreName(), store.getStoreAddressX(), store.getStoreAddressY(), store.getStoreOpenAt(), store.getStoreCloseAt(), store.getStorePhone(), store.getStoreMinimumOrderAmount(), store.getStoreIntroduction(), store.getStoreCategory());
    }
}
