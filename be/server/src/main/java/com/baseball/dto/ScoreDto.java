package com.baseball.dto;

public class ScoreDto {
    private Integer awayScore;
    private Integer homeScore;

    public ScoreDto(Integer awayScore, Integer homeScore) {
        this.awayScore = awayScore;
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }
}
