package com.example.store.global.exception;

public class CustomerNotFoundException extends IllegalArgumentException{
    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
