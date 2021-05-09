package com.baseball.exception;

public class MatchNotFoundException extends NullPointerException {
    public MatchNotFoundException(String id) {
        super(String.format("존재하지 않는 Match Id 입니다; %s", id));
    }
}
