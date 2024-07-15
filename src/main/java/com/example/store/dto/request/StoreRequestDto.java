package com.example.store.dto.request;

import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreRequestDto(
        String storeName, String storeAddress, LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction, StoreCategory storeCategory,
        Long ownerId
) {
    public Store toEntity() {
        Owner owner = Owner.builder().ownerId(ownerId).build();
        return Store.builder()
                .storeName(storeName)
                .storeAddress(storeAddress)
                .storeOpenAt(storeOpenAt)
                .storeCloseAt(storeCloseAt)
                .storePhone(storePhone)
                .storeMinimumOrderAmount(storeMinimumOrderAmount)
                .storeIntroduction(storeIntroduction)
                .storeCategory(storeCategory)
                .owner(owner)
                .build();
    }
}
