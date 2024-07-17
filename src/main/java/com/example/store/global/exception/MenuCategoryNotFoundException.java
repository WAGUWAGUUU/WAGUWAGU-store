package com.example.store.global.exception;

public class MenuCategoryNotFoundException extends IllegalArgumentException{
    public MenuCategoryNotFoundException() {
        super("MenuCategory not found");
    }
}
