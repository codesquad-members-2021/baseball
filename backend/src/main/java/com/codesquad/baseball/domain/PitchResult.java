package com.codesquad.baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PitchResult {
    private PlayType playType;
    private List<Integer> backHomeRunners = new ArrayList<>();

    public PitchResult(PlayType playType) {
        this.playType = playType;
    }

    public int numberOfRunners() {
        return backHomeRunners.size();
    }

    public int findRunnerByOrder(int order) {
        return backHomeRunners.get(order);
    }

    public boolean hasRunner() {
        return backHomeRunners.size() > 0;
    }

    public void addRunner(int runner) {
        if (runner == Game.NO_PLAYER) {
            return;
        }
        backHomeRunners.add(runner);
    }

    public void addRunner(List<Integer> runners) {
        backHomeRunners.addAll(runners);
    }

    public void changePlayTypeToStrikeOut() {
        playType = PlayType.STRIKE_OUT;
    }

    public void changePlayTypeToFourBall() {
        playType = PlayType.FOUR_BALL;
    }

    public PlayType getPlayType() {
        return playType;
    }

    public List<Integer> getBackHomeRunners() {
        return backHomeRunners;
    }
}
