package com.example.store.controller.exceptionController;

import com.example.store.global.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OptionExceptionController {
    @ExceptionHandler(OptionAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String optionAlreadyExistsExceptionHandler(OptionAlreadyExistsException e){
        return e.getMessage();
    }

    @ExceptionHandler(OptionNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String optionNotFoundExceptionHandler(OptionNotFoundException e){
        return e.getMessage();
    }


}
