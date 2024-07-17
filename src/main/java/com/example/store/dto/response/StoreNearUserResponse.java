package com.example.store.dto.response;

public interface StoreNearUserResponse {
    Long ownerId();
    String getStoreName();
    String getStoreAddress();
    double getStoreLatitude();
    double getStoreLongitude();
    int getStoreMinimumOrderAmount();
}