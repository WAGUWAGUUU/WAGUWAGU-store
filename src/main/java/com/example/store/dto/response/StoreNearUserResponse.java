package com.example.store.dto.response;

public interface StoreNearUserResponse {
    Long getOwnerId();
    Long getStoreId();
    String getStoreName();
    String getStoreAddress();
    double getStoreLongitude();
    double getStoreLatitude();
    int getStoreMinimumOrderAmount();
    String getStoreIntroduction();
}