package com.codesquad.baseball.dto;

import org.springframework.http.HttpStatus;

public class ErrorDTO {
    HttpStatus status;
    private String reason;

    public ErrorDTO(HttpStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }
}
