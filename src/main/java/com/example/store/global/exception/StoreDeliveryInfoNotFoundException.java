package com.example.store.global.exception;

public class StoreDeliveryInfoNotFoundException extends IllegalArgumentException{
    public StoreDeliveryInfoNotFoundException() {
        super("StoreDeliveryInfo not found");
    }
}
