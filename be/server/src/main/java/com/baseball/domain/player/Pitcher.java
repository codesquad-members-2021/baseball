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
        // TODO: pitchResult 에 따른 상태변화를 TDD 로 구현
        if (playResult == PlayResult.STRIKE) {
            numberOfPitching++;
            strikeCount++;
        }
        if (playResult == PlayResult.BALL) {
            numberOfPitching++;
            ballCount++;
        }
    }

    public Integer getNumberOfPitching() {
        return numberOfPitching;
    }

    public Float getBaseOnBalls() {
        return (float) ballCount / 4;
    }

    private Integer getOutCount() {
        return strikeCount / 3;
    }

    public Float getInnings() {
        return (float) getOutCount() / 3;

    }

}
