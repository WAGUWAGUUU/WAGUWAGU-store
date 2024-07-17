package com.example.store.controller.exceptionController;

import com.example.store.global.exception.MenuCategoryAlreadyExistsException;
import com.example.store.global.exception.MenuCategoryNotFoundException;
import com.example.store.global.exception.StoreAlreadyExistsException;
import com.example.store.global.exception.StoreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MenuCategoryExceptionController {
    @ExceptionHandler(MenuCategoryAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuCategoryAlreadyExistsExceptionHandler(MenuCategoryAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(MenuCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuCategoryNotFoundExceptionHandler(MenuCategoryNotFoundException e){
        return e.getMessage();
    }
}
