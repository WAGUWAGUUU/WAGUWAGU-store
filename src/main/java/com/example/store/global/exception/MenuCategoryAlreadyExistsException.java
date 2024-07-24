package com.example.store.global.exception;

public class MenuCategoryAlreadyExistsException extends IllegalArgumentException{
    public MenuCategoryAlreadyExistsException() {
        super("MenuCategory already exists");
    }
}
