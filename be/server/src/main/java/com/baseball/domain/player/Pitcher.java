package com.baseball.domain.player;

import com.baseball.domain.match.PlayResult;

public class Pitcher extends Player {
    private Integer numberOfPitching = 0;
    private Integer ballCount = 0;
    private Integer strikeCount = 0;

    public Pitcher(String name) {
        super(name);
    }

    @Override
    public void play(PlayResult playResult) {
        numberOfPitching++;

        if (playResult == PlayResult.STRIKE) {
            strikeCount++;
        }
        if (playResult == PlayResult.BALL) {
            ballCount++;
        }
        if (playResult == PlayResult.HIT) {
            increaseHit();
        }
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Integer getBaseOnBalls() {
        return ballCount / 4;
    }

    private Integer getOutCount() {
        return strikeCount / 3;
    }

    public Float getInnings() {
        return (float) getOutCount() / 3;

    }

}
