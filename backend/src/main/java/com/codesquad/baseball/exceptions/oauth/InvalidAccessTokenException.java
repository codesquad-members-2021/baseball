package com.codesquad.baseball.exceptions.oauth;

public class InvalidAccessTokenException extends InvalidTokenException {
    public static final String INVALID_ACCESS_TOKEN = "사용자의 액세스토큰이 아닙니다";

    public InvalidAccessTokenException(String message) {
        super(message);
    }
}
