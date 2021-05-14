package com.dong.baseball.Exception;

public class PlayerNotFoundException extends NotFoundException {
    private static final String PLAYER_NOT_FOUND_MESSAGE = "Cannot Found Player";

    public PlayerNotFoundException() {
        super(PLAYER_NOT_FOUND_MESSAGE);
    }

}
