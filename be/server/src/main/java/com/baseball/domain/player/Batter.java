package com.baseball.domain.player;

public class Batter extends Player {
    private Integer plateAppearances = 0;
    private Integer out = 0;
    private Float average = 0F;

    public Batter(String name) {
        super(name);
    }

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
