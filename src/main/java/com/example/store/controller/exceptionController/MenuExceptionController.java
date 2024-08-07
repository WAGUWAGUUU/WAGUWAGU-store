package com.example.store.controller.exceptionController;

import com.example.store.global.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MenuExceptionController {
    @ExceptionHandler(MenuAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuAlreadyExistsExceptionHandler(MenuAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(MenuNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuNotFoundExceptionHandler(MenuNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(MenuTypeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuTypeNotFoundExceptionHandler(MenuTypeNotFoundException e){
        return e.getMessage();
    }

    @ExceptionHandler(MenuInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String menuInputExceptionHandler(MenuInputException e){
        return e.getMessage();
    }

}
