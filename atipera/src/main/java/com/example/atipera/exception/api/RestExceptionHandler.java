package com.example.atipera.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Object userNotFoundExceptionValidation(UserNotFoundException ex) {
        return new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage());
    }

    @ExceptionHandler(NotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public Object notAcceptableExceptionValidation(NotAcceptableException ex) {
        return new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage());
    }
}
