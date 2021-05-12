package com.codesquad.baseball.exceptions;

public class GameIsNotStartedException extends NotFoundException {
    private static final String GAME_IS_NOT_STARTED_ERROR_MESSAGE = "시작되지 않은 게임입니다. 피치할 수 없습니다";

    public GameIsNotStartedException() {
        super(GAME_IS_NOT_STARTED_ERROR_MESSAGE);
    }
}
