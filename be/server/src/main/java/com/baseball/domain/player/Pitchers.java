package com.baseball.domain.player;

import java.util.List;

public class Pitchers {
    private Integer pitcherIndex;
    private final List<Pitcher> pitchers;

    public Pitchers(List<Pitcher> pitchers) {
        this.pitchers = pitchers;
    }

    public List<Pitcher> getPitchers() {
        return pitchers;
    }

    public Pitcher getPitcher() {
        return pitchers.get(pitcherIndex);
    }

    public void changePitcher() {
        pitcherIndex = (pitcherIndex + 1) % pitchers.size();
    }
}
