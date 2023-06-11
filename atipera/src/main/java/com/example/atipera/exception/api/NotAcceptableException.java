package com.example.atipera.exception.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic exception for not acceptable related errors.
 * Will resolve to the {@link HttpStatus#NOT_ACCEPTABLE} if handled by the Spring's exception handler.
 */
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
@Getter
public class NotAcceptableException extends BusinessException {
    private final int errorCode = HttpStatus.NOT_ACCEPTABLE.value();
    private final String errorMessage = "NOT ACCEPTABLE FORMAT DATE!!!";
}
