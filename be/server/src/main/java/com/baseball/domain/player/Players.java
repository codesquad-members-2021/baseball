package com.baseball.domain.player;

import java.util.List;

public class Players {
    private final Pitchers pitchers;
    private final Batters batters;

    public Players(List<Pitcher> pitchers, List<Batter> batters) {
        this.pitchers = new Pitchers(pitchers);
        this.batters = new Batters(batters);
    }

    public List<Pitcher> getPitchers() {
        return pitchers.getPitchers();
    }

    public List<Batter> getBatters() {
        return batters.getBatters();
    }

    public Pitcher getPitcher() {
        return pitchers.getPitcher();
    }

    public Batter getBatter() {
        return batters.getBatter();
    }

    public void changePitcher() {
        pitchers.changePitcher();
    }

    public void changeBatter() {
        batters.changeBatter();
    }
}
