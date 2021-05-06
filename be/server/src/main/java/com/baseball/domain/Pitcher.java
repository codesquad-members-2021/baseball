package com.baseball.domain;

public class Pitcher {
    private final String name;
    private final Integer numberOfPitching;
    private final Integer hit;
    private final Integer baseOnBalls;
    private final Integer innings;

    public Pitcher(String name, Integer numberOfPitching, Integer hit, Integer baseOnBalls, Integer innings) {
        this.name = name;
        this.numberOfPitching = numberOfPitching;
        this.hit = hit;
        this.baseOnBalls = baseOnBalls;
        this.innings = innings;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Integer getHit() {
        return hit;
    }

    public Integer getBaseOnBalls() {
        return baseOnBalls;
    }

    public Integer getInnings() {
        return innings;
    }
}
