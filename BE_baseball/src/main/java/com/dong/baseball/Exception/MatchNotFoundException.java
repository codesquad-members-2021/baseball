package com.dong.baseball.Exception;

public class MatchNotFoundException extends NotFoundException {
    private static final String MATCH_NOT_FOUND_MESSAGE = "Cannot Found Match";;

    public MatchNotFoundException() {
        super(MATCH_NOT_FOUND_MESSAGE);
    }
}
