package com.example.store.dto.response;

public interface StoreNearUserResponse {
    Long getOwnerId();
    String getStoreName();
    String getStoreAddress();
    double getStoreLatitude();
    double getStoreLongitude();
    int getStoreMinimumOrderAmount();
}