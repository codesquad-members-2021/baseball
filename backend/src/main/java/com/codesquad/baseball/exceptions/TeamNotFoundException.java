package com.codesquad.baseball.exceptions;

public class TeamNotFoundException extends NotFoundException{
    private static final String TEAM_NOT_FOUND_ERROR_MESSAGE = "팀을 찾지 못했습니다. id : ";

    public TeamNotFoundException(int id) {
        super(TEAM_NOT_FOUND_ERROR_MESSAGE + id);
    }
}
