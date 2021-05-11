package com.codesquad.baseball.domain;

public class Score {

    private int inning;
    private int score;

    public Score(int inning, int score) {
        this.inning = inning;
        this.score = score;
    }

    public int getInning() {
        return inning;
    }

    public int getScore() {
        return score;
    }
}
