package com.baseball.domain.player;

import java.util.List;

public class Players {
    private final List<Pitcher> pitchers;
    private final List<Batter> batters;

    public Players(List<Pitcher> pitchers, List<Batter> batters) {
        this.pitchers = pitchers;
        this.batters = batters;
    }

    public List<Pitcher> getPitchers() {
        return pitchers;
    }

    public List<Batter> getBatters() {
        return batters;
    }
}
