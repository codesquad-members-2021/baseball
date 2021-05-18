package com.codesquad.baseball.error.exception;

import com.codesquad.baseball.error.ErrorCode;

public class GameNotFoundException extends NotFoundException {

    public GameNotFoundException() {
        super(ErrorCode.GAME_NOT_FOUND_EXCEPTION);
    }
}
