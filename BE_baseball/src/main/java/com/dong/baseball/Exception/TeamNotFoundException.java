package com.dong.baseball.Exception;

public class TeamNotFoundException extends NotFoundException {
    private static final String TEAM_NOT_FOUND_MESSAGE = "Cannot Found Team";

    public TeamNotFoundException() {
        super(TEAM_NOT_FOUND_MESSAGE);
    }

}
