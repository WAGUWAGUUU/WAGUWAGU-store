package com.example.store.global.exception;

public class MenuNotFoundException extends IllegalArgumentException{
    public MenuNotFoundException() {
        super("Menu not found");
    }
}
