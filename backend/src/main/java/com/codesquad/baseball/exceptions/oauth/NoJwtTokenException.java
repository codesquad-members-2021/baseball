package com.codesquad.baseball.exceptions.oauth;

public class NoJwtTokenException extends JwtTokenException {
    public static final String NO_TOKEN_IN_REQUEST_HEADER = "Request Header에 토큰을 첨부하지 않았습니다.";

    public NoJwtTokenException(String message) {
        super(message);
    }
}
