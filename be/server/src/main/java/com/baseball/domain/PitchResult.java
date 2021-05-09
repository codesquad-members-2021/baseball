package com.baseball.domain;

public enum PitchResult {
    BALL, HIT, STRIKE;

    public PitchResult of(String name) {
        name = name.toUpperCase();
        return valueOf(name);
    }

    public Boolean toBoolean() {
        return this == STRIKE;
    }
}
