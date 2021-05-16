package com.codesquad.baseball.exceptions.game;

public class NotYourGameException extends RuntimeException {
    private static final String NotYourGameException = "요창한 유저는 해당 게임에 접근할 수 있는 권한이 없습니다";

    public NotYourGameException() {
        super(NotYourGameException);
    }
}
