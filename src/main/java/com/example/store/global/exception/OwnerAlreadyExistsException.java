package com.example.store.global.exception;

public class OwnerAlreadyExistsException extends IllegalArgumentException{
    public OwnerAlreadyExistsException() {
        super("Owner already exists");
    }
}
