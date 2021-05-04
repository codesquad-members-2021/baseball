package com.baseball.dto;

public class ScoreDto {
    private final Integer awayScore;
    private final Integer homeScore;

    public ScoreDto(Integer awayScore, Integer homeScore) {
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
