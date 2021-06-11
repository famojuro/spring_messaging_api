package com.innovativeapps.com.messagingapp.util.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class AppErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private String errorCode;
    String errorMessage;
    private int status;

    public AppErrorResponse(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessageg() {
        return errorMessage;
    }

    public void setErrorMsg(String errorMessage) {
        this.errorMessage= errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
