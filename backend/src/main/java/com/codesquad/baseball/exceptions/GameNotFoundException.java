package com.codesquad.baseball.exceptions;

public class GameNotFoundException extends NotFoundException{
    private static final String GAME_NOT_FOUND_ERROR_MESSAGE = "게임을 찾지 못했습니다. id : ";

    public GameNotFoundException(int id) {
        super(GAME_NOT_FOUND_ERROR_MESSAGE + id);
    }
}
