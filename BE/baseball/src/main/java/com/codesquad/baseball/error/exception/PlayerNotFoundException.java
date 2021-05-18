package com.codesquad.baseball.error.exception;

import com.codesquad.baseball.error.ErrorCode;

public class PlayerNotFoundException extends NotFoundException {

    public PlayerNotFoundException() {
        super(ErrorCode.PLAYER_NOT_FOUND_EXCEPTION);
    }
}
