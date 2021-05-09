package com.codesquad.baseball.error;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private HttpStatus status;

    private String message;

    private ErrorResponse(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }

    public static ErrorResponse of(ErrorCode errorCode) {
        return new ErrorResponse(errorCode);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
