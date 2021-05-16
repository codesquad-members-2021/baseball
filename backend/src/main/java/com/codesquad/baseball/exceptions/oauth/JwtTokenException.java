package com.codesquad.baseball.exceptions.oauth;

public class JwtTokenException extends RuntimeException{
    public JwtTokenException(String message) {
        super(message);
    }
}
