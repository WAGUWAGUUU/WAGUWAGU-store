package com.example.store.global.exception;

public class MenuInputException extends IllegalArgumentException{
    public MenuInputException() {
        super("MenuInput wrong");
    }
}
