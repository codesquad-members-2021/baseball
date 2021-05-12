package com.codesquad.baseball.exceptions.notfound;

public class TeamNotFoundException extends NotFoundException {

    public static final String HOME_TEAM_NOT_FOUND = "홈팀을 찾지 못했습니다.";
    public static final String AWAY_TEAM_NOT_FOUND = "원정팀을 찾지 못했습니다.";
    private static final String FIND_BY_ID_FAILED = "팀을 찾지 못했습니다. id : ";

    public TeamNotFoundException(int id) {
        super(FIND_BY_ID_FAILED + id);
    }

    public TeamNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
