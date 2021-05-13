package com.dong.baseball.Exception;

public class PlayerNotFoundException extends NotFoundException {
    private static final String ERROR_MESSAGE = "Cannot Found Player";

    public PlayerNotFoundException() {
        super(ERROR_MESSAGE);
    }

}
