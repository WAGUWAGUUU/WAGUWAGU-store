package com.example.store.global.exception;

public class StoreTypeNotFoundException extends IllegalArgumentException{
    public StoreTypeNotFoundException() {
        super("StoreType not found");
    }
}
