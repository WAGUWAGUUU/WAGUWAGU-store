package com.example.store.controller.exceptionController;

import com.example.store.global.exception.StoreAlreadyExistsException;
import com.example.store.global.exception.StoreDeliveryInfoAlreadyExistsException;
import com.example.store.global.exception.StoreDeliveryInfoNotFoundException;
import com.example.store.global.exception.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StoreDeliveryInfoExceptionController {
    @ExceptionHandler(StoreDeliveryInfoAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storeAlreadyExistsExceptionHandler(StoreDeliveryInfoAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(StoreDeliveryInfoNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String storeNotFoundExceptionHandler(StoreDeliveryInfoNotFoundException e){
        return e.getMessage();
    }
}
