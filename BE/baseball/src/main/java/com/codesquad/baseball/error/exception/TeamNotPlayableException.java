package com.codesquad.baseball.error.exception;

import com.codesquad.baseball.error.ErrorCode;

public class TeamNotPlayableException extends RuntimeException {

    private final ErrorCode errorCode;

    public TeamNotPlayableException(){
        super(ErrorCode.TEAM_NOT_FOUND_EXCEPTION.getMessage());
        this.errorCode = ErrorCode.TEAM_NOT_PLAYABLE_EXCEPTION;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
