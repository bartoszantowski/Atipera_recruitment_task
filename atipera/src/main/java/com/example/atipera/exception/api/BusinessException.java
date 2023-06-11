package com.example.atipera.exception.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Generic exception for business related errors.
 * Will resolve to the {@link HttpStatus#BAD_REQUEST} if handled by the Spring's exception handler.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class BusinessException extends RuntimeException {
}
