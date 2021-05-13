package com.codesquad.baseball.exceptions.oauth;

public class InvalidJwtTokenException extends RuntimeException {
    public static final String BAD_TOKEN = "Authorization의 값이 잘못되었습니다! 형식은 bearer TOKEN_STRING 이어야 합니다";
    public static final String EXPIRED_JWT_EXCEPTION = "만료된 토큰입니다";
    public static final String UNSUPPORTED_JWT_EXCEPTION = "지원되지 않는 토큰입니다";
    public static final String MALFORMED_JWT_EXCEPTION = "토큰 형식이 잘못되었습니다";
    public static final String SIGNATURE_EXCEPTION = "토큰의 시그니쳐 검증을 실패했습니다";
    public static final String ILLEGAL_ARGUMENT_EXCEPTION = "아규먼트 형식이 잘못되었습니다";

    public InvalidJwtTokenException(String message) {
        super(message);
    }
}
