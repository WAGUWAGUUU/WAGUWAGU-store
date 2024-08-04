package com.example.store.dto.request;

import com.example.store.global.entity.Owner;
import com.example.store.global.entity.Store;
import com.example.store.global.type.StoreCategory;

import java.time.LocalTime;

public record StoreRequestDto(
        String storeName, String storeAddress, double storeLongitude, double storeLatitude,LocalTime storeOpenAt, LocalTime storeCloseAt, String storePhone, int storeMinimumOrderAmount, String storeIntroduction, String storeCategory,
        Long ownerId
) {
    public Store toEntity() {
        Owner owner = Owner.builder().ownerId(ownerId).build();
        return Store.builder()
                .storeName(storeName)
                .storeAddress(storeAddress)
                .storeLongitude(storeLongitude)
                .storeLatitude(storeLatitude)
                .storeOpenAt(storeOpenAt)
                .storeCloseAt(storeCloseAt)
                .storePhone(storePhone)
                .storeMinimumOrderAmount(storeMinimumOrderAmount)
                .storeIntroduction(storeIntroduction)
                .storeCategory(StoreCategory.stringToCategory(storeCategory))
                .owner(owner)
                .storeBlockIsOpened(false)
                .build();
    }
}
