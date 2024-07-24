package com.example.store.controller.exceptionController;

import com.example.store.global.exception.CustomerNotFoundException;
import com.example.store.global.exception.MenuAlreadyExistsException;
import com.example.store.global.exception.MenuNotFoundException;
import com.example.store.global.exception.MenuTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionController {
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String customerNotFoundExceptionHandler(CustomerNotFoundException e){
        return e.getMessage();
    }

}
