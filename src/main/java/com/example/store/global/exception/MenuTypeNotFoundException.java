package com.example.store.global.exception;

public class MenuTypeNotFoundException extends IllegalArgumentException{
    public MenuTypeNotFoundException() {
        super("MenuType not found");
    }
}
