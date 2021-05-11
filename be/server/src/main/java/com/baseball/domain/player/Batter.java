package com.baseball.domain.player;

import com.baseball.domain.match.PlayResult;

public class Batter extends Player {
    private Integer plateAppearances = 0;
    private Integer strikeCount = 0;

    public Batter(String name) {
        super(name);
    }

    @Override
    public void play(PlayResult playResult) {

        if (playResult == PlayResult.HIT) {
            increaseHit();
        }
        if (playResult == PlayResult.STRIKE) {
            strikeCount++;

        }
    }

    public void increasePlateAppearances() {
    }

    public Integer getPlateAppearances() {
        return plateAppearances;
    }

    public Integer getOut() {
        return strikeCount / 3;
    }

    public Float getAverage() {
        return (float) getHit() / plateAppearances;
    }
}
