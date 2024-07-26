package com.example.store.global.exception;

public class OptionListNotFoundException extends IllegalArgumentException{
    public OptionListNotFoundException() {
        super("OptionList not found");
    }
}
