package com.example.store.controller.exceptionController;

import com.example.store.global.exception.OptionListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OptionListExceptionController {

    @ExceptionHandler(OptionListNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String optionListNotFoundExceptionHandler(OptionListNotFoundException e){
        return e.getMessage();
    }

}
