package com.example.store.global.exception;

public class MenuAlreadyExistsException extends IllegalArgumentException{
    public MenuAlreadyExistsException() {
        super("Menu already exists");
    }
}
