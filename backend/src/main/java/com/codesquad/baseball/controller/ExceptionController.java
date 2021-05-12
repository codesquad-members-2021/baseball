package com.codesquad.baseball.controller;

import com.codesquad.baseball.dto.ErrorDTO;
import com.codesquad.baseball.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(GameAlreadyOccupiedException.class)
    public ErrorDTO handleGameAlreadyOccupiedException(GameAlreadyOccupiedException exception) {
        return new ErrorDTO(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({PlayerNotFoundException.class, TeamNotFoundException.class, GameNotFoundException.class})
    public ErrorDTO handlePlayerNotFoundException(NotFoundException exception) {
        return new ErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
