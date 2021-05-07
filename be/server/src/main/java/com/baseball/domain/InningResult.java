package com.baseball.domain;

public enum InningResult {
    BALL, HIT, STRIKE;

    public InningResult of(String name) {
        name = name.toUpperCase();
        return valueOf(name);
    }
}
