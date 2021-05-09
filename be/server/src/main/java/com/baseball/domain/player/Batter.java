package com.baseball.domain.player;

public class Batter extends Player {
    private final Integer plateAppearances;
    private final Integer out;
    private final Float average;

    public Batter(String name, Integer plateAppearances, Integer hit, Integer out, Float average) {
        super(name, hit);
        this.plateAppearances = plateAppearances;
        this.out = out;
        this.average = average;
    }
    
    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public Integer getOut() {
        return out;
    }

    public Float getAverage() {
        return average;
    }
}
