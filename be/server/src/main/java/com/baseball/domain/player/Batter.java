package com.baseball.domain.player;

public class Batter extends Player {
    private Integer plateAppearances = 1;
    private Integer out = 0;

    public Batter(String name) {
        super(name);
    }

    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public Integer getOut() {
        return out;
    }

    public Float getAverage() {
        return (float) getHit() / plateAppearances;
    }
}
