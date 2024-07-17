package com.example.store.global.exception;

public class StoreAlreadyExistsException extends IllegalArgumentException{
    public StoreAlreadyExistsException() {
        super("Store already exists");
    }
}
