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
        // TODO: pitchResult 에 따른 상태변화를 TDD 로 구현

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
