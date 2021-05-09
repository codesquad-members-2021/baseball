package com.baseball.domain.player;

public class Pitcher extends Player {
    private Integer numberOfPitching = 0;
    private Integer baseOnBalls = 0;
    private Integer innings = 0;

    public Pitcher(String name) {
        super(name);
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Integer getBaseOnBalls() {
        return baseOnBalls;
    }

    public Integer getInnings() {
        return innings;
    }
}
