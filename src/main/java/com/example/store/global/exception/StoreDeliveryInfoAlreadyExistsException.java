package com.example.store.global.exception;

public class StoreDeliveryInfoAlreadyExistsException extends IllegalArgumentException{
    public StoreDeliveryInfoAlreadyExistsException() {
        super("StoreDeliveryInfo already exists");
    }
}
