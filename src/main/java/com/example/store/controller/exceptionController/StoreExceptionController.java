package com.example.store.controller.exceptionController;

import com.example.store.global.exception.StoreAlreadyExistsException;
import com.example.store.global.exception.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreExceptionController {
    @ExceptionHandler(StoreAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storeAlreadyExistsExceptionHandler(StoreAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(StoreNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storeNotFoundExceptionHandler(StoreNotFoundException e){
        return e.getMessage();
    }
}
