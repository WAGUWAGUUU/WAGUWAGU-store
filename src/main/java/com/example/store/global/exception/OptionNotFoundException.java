package com.example.store.global.exception;

public class OptionNotFoundException extends IllegalArgumentException{
    public OptionNotFoundException() {
        super("Option not found");
    }
}
