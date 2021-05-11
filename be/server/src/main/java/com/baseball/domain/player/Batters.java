package com.baseball.domain.player;

import java.util.List;

public class Batters {
    private Integer batterIndex = 0;
    private final List<Batter> batters;

    public Batters(List<Batter> batters) {
        this.batters = batters;
        getBatter().increasePlateAppearances();
    }


    public List<Batter> getBatters() {
        return batters;
    }

    public Batter getBatter() {
        return batters.get(batterIndex);
    }

    public void changeBatter() {
        batterIndex = (batterIndex + 1) % batters.size();
        getBatter().increasePlateAppearances();
    }
}
