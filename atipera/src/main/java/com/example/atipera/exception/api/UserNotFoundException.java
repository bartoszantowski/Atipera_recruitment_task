package com.example.atipera.exception.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic exception for user not found errors.
 * Will resolve to the {@link HttpStatus#NOT_FOUND} if handled by the Spring's exception handler.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class UserNotFoundException extends BusinessException {
    private final int errorCode = HttpStatus.NOT_FOUND.value();
    private String errorMessage = "User: %s not found!!!";

    public UserNotFoundException(String userName) {
        this.errorMessage = String.format(errorMessage, userName);
    }
}
