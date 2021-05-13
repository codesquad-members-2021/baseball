package com.dong.baseball.Exception;

public class MatchNotFoundException extends NotFoundException {
    private static final String ERROR_MESSAGE = "Match";

    public MatchNotFoundException() {
        super(ERROR_MESSAGE);
    }
}
