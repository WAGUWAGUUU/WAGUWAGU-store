package com.example.store.global.exception;

public class OwnerTypeNotFoundException extends IllegalArgumentException{
    public OwnerTypeNotFoundException() {
        super("OwnerType not found");
    }
}
