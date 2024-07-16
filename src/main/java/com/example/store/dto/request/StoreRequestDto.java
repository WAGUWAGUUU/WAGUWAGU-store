package com.example.store.dto.request;

import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreRequestDto(
        String storeName, String storeAddressString, double storeAddressX, double storeAddressY,LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction, StoreCategory storeCategory,
        Long ownerId
) {
    public Store toEntity() {
        Owner owner = Owner.builder().ownerId(ownerId).build();
        return Store.builder()
                .storeName(storeName)
                .storeAddressString(storeAddressString)
                .storeAddressX(storeAddressX)
                .storeAddressY(storeAddressY)
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
