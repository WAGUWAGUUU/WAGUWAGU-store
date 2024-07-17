package com.example.store.global.exception;

public class OwnerNotFoundException extends IllegalArgumentException{
    public OwnerNotFoundException() {
        super("Owner not found");
    }
}
