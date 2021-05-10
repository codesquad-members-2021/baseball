package com.baseball.exception;

public class MatchOccupiedException extends RuntimeException {
    public MatchOccupiedException() {
        super("다른 사람이 선점한 경우에는 게임에 참가할 수 없습니다.");
    }
}
