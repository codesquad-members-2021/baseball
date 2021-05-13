package com.codesquad.baseball.exceptions.game;

import com.codesquad.baseball.exceptions.notfound.NotFoundException;

public class GameAlreadyOccupiedException extends NotFoundException {
    private static final String GAME_IS_ALREADY_OCCUPIED_ERROR_MESSAGE = "방이 다 찼습니다. id : ";

    public GameAlreadyOccupiedException(int id) {
        super(GAME_IS_ALREADY_OCCUPIED_ERROR_MESSAGE + id);
    }
}
