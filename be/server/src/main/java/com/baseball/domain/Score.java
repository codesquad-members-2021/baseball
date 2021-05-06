package com.baseball.domain;

public class Score {
    private final Integer awayScore;
    private final Integer homeScore;

    public Score(Integer awayScore, Integer homeScore) {
        this.awayScore = awayScore;
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }
}
