package com.example.store.dto.response;

public record StoreListResponse (
    Long ownerId, Long storeId, String storeName, String storeAddress,
    double storeLongitude,  double storeLatitude,int storeMinimumOrderAmount, String storeIntroduction, boolean storeBlockIsOpened, String storeImage, double distanceFromStoreToCustomer, int deliveryFee
    ){
}
