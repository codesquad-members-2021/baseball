package com.codesquad.baseball.error.exception;

import com.codesquad.baseball.error.ErrorCode;

public class TeamNotFoundException extends NotFoundException {

    public TeamNotFoundException() {
        super(ErrorCode.TEAM_NOT_FOUND_EXCEPTION);
    }
}
