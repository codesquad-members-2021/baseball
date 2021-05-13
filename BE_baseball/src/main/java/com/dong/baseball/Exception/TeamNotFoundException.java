package com.dong.baseball.Exception;

public class TeamNotFoundException extends NotFoundException {
    private static final String ERROR_MESSAGE = "Cannot Found Player";

    public TeamNotFoundException() {
        super(ERROR_MESSAGE);
    }

}
