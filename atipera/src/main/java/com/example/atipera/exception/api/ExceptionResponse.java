package com.example.atipera.exception.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ExceptionResponse {
    private int status;
    private String message;
}
