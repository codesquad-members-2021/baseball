package com.codesquad.baseball.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // NotFoundExceptions
    GAME_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당하는 게임을 찾을 수 없습니다."),
    TEAM_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당하는 팀을 찾을 수 없습니다."),
    PLAYER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당하는 선수를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
