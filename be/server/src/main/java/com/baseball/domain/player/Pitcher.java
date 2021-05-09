package com.baseball.domain.player;

public class Pitcher extends Player {
    private final Integer numberOfPitching;
    private final Integer baseOnBalls;
    private final Integer innings;

    public Pitcher(String name, Integer numberOfPitching, Integer hit, Integer baseOnBalls, Integer innings) {
        super(name, hit);
        this.numberOfPitching = numberOfPitching;
        this.baseOnBalls = baseOnBalls;
        this.innings = innings;
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
