package com.baseball.domain.player;

import com.baseball.domain.match.PlayResult;

public class Batter extends Player {
    private Integer plateAppearances = 1;
    private Integer strikeCount = 0;

    public Batter(String name) {
        super(name);
    }

    @Override
    public void play(PlayResult playResult) {

        if (playResult == PlayResult.HIT) {
            increseHit();
        }
        if (playResult == PlayResult.STRIKE) {
            strikeCount++;

        }
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
