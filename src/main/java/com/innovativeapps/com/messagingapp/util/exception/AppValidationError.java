package com.innovativeapps.com.messagingapp.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AppValidationError extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;

    public AppValidationError(String message) {
        super(message);
        this.message = message;
    }
}
