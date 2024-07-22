package com.example.store.dto.response;

public record StoreListResponse (
    Long ownerId, Long storeId, String storeName, String storeAddress,
    double storeLongitude,  double storeLatitude,int storeMinimumOrderAmount, double distanceFromStoreToCustomer, int deliveryFee
    ){
}
