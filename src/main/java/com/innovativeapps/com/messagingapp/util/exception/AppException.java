package com.innovativeapps.com.messagingapp.util.exception;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

@RestControllerAdvice
public class AppException extends RuntimeException{
    private static final String TOKEN_ID = "tokenId";
    private String msg;

    private static final Logger log = LoggerFactory.getLogger(AppException.class);

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<AppErrorResponse> handleGenericNotFoundException(NotFoundException e) {
        AppErrorResponse errorResponse = new AppErrorResponse("NOT_FOUND_ERROR", e.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus((HttpStatus.NOT_FOUND.value()));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<AppErrorResponse> handleUserAlreadyExistException(NotFoundException e) {
        AppErrorResponse errorResponse = new AppErrorResponse("USER_ALREADY_EXIST_ERROR", e.getMessage());
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus((HttpStatus.NOT_FOUND.value()));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
