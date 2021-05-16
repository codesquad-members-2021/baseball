package com.codesquad.baseball.controller;

import com.codesquad.baseball.dto.etc.ErrorDTO;
import com.codesquad.baseball.exceptions.game.GameAlreadyOccupiedException;
import com.codesquad.baseball.exceptions.game.GameIsNotStartedException;
import com.codesquad.baseball.exceptions.game.NotYourGameException;
import com.codesquad.baseball.exceptions.notfound.NotFoundException;
import com.codesquad.baseball.exceptions.oauth.InvalidAccessTokenException;
import com.codesquad.baseball.exceptions.oauth.InvalidRefreshTokenException;
import com.codesquad.baseball.exceptions.oauth.InvalidTokenException;
import com.codesquad.baseball.exceptions.oauth.JwtTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
    @ExceptionHandler(NotFoundException.class)
    public ErrorDTO handleNotFoundException(NotFoundException exception) {
        return new ErrorDTO(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(GameIsNotStartedException.class)
    public ErrorDTO handleGameIsNotStartedException(GameIsNotStartedException exception) {
        return new ErrorDTO(HttpStatus.CONFLICT, exception.getMessage());
    }


    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorDTO handleMethodNotAllowed(HttpRequestMethodNotSupportedException exception) {
        return new ErrorDTO(HttpStatus.METHOD_NOT_ALLOWED, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JwtTokenException.class)
    public ErrorDTO handleNoJwtTokenException(JwtTokenException exception) {
        return new ErrorDTO(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({InvalidAccessTokenException.class, InvalidRefreshTokenException.class})
    public ErrorDTO handleInvalidTokenException(InvalidTokenException exception) {
        return new ErrorDTO(HttpStatus.CONFLICT, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(NotYourGameException.class)
    public ErrorDTO handleNotYourGameException(NotYourGameException exception) {
        return new ErrorDTO(HttpStatus.FORBIDDEN, exception.getMessage());
    }

}
