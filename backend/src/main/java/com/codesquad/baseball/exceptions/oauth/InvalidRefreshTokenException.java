package com.codesquad.baseball.exceptions.oauth;

public class InvalidRefreshTokenException extends InvalidTokenException {
    public static final String INVALID_REFRESH_TOKEN = "사용자의 리프래시 토큰이 아닙니다";

    public InvalidRefreshTokenException(String message) {
        super(message);
    }
}
