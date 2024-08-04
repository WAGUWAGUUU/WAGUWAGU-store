package com.example.store.dto.response;

import java.time.LocalTime;

public interface StoreNearUserResponse {
    Long getOwnerId();
    Long getStoreId();
    String getStoreName();
    String getStoreAddress();
    double getStoreLongitude();
    double getStoreLatitude();
    int getStoreMinimumOrderAmount();
    String getStoreIntroduction();

    Boolean getStoreBlockIsOpened();

}