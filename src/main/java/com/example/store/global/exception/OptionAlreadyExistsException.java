package com.example.store.global.exception;

public class OptionAlreadyExistsException extends IllegalArgumentException{
    public OptionAlreadyExistsException() {
        super("Option already exists");
    }
}
