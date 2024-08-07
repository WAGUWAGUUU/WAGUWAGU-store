package com.example.store.global.exception;

public class OptionListNameAlreadyExistsException extends RuntimeException {
    public OptionListNameAlreadyExistsException() {
        super("An option list with this name already exists.");
    }
}
