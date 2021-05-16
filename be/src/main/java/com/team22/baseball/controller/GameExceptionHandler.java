package com.team22.baseball.controller;

import com.team22.baseball.dto.response.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GameExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiResult notAuthorizedException(RuntimeException exception) {
        return ApiResult.failed(exception);
    }
}
