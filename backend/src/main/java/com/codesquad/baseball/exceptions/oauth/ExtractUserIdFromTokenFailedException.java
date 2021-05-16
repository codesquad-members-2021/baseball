package com.codesquad.baseball.exceptions.oauth;

public class ExtractUserIdFromTokenFailedException extends RuntimeException {
    public static final String EXTRACTION_FAILED = "인터셉터로부터 UserID를 전달받지 못했습니다";

    public ExtractUserIdFromTokenFailedException(String message) {
        super(message);
    }
}
