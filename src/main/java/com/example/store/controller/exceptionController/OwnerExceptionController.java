package com.example.store.controller.exceptionController;

import com.example.store.global.exception.OwnerAlreadyExistsException;
import com.example.store.global.exception.OwnerNotFoundException;
import com.example.store.global.exception.StoreAlreadyExistsException;
import com.example.store.global.exception.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OwnerExceptionController {
    @ExceptionHandler(OwnerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String ownerAlreadyExistsExceptionHandler(OwnerAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String OwnerNotFoundExceptionHandler(OwnerNotFoundException e){
        return e.getMessage();
    }
}
