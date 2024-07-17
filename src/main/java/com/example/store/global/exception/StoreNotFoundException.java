package com.example.store.global.exception;

public class StoreNotFoundException extends IllegalArgumentException{
    public StoreNotFoundException() {
        super("Store not found");
    }
}
