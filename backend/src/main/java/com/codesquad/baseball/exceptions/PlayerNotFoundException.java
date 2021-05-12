package com.codesquad.baseball.exceptions;

public class PlayerNotFoundException extends NotFoundException {

    public static final String FIND_PITCHER_FAILED = "투수를 찾지 못했습니다.";
    public static final String FIND_STARTING_PITCHER_FAILED = "선발투수를 찾지 못했습니다.";
    public static final String FIND_PLAYER_FAILED = "선수를 찾지 못했습니다.";

    public PlayerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
