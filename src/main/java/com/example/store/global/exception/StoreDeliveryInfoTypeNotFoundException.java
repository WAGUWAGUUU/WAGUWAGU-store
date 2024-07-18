package com.example.store.global.exception;

public class StoreDeliveryInfoTypeNotFoundException extends IllegalArgumentException{
    public StoreDeliveryInfoTypeNotFoundException() {
        super("StoreDeliveryInfoType not found");
    }
}
