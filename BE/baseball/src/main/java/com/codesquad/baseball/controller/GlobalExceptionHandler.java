package com.codesquad.baseball.controller;

import com.codesquad.baseball.error.ErrorResponse;
import com.codesquad.baseball.error.exception.NotFoundException;
import com.codesquad.baseball.error.exception.TeamNotPlayableException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ErrorResponse.of(e.getErrorCode()), response.getStatus());
    }

    @ExceptionHandler(TeamNotPlayableException.class)
    public ResponseEntity<ErrorResponse> handleTeamNotPlayableException(TeamNotPlayableException e) {
        ErrorResponse response = ErrorResponse.of(e.getErrorCode());
        return new ResponseEntity<>(response, response.getStatus());
    }
}
