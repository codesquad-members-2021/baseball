package com.baseball.dto;

import com.baseball.domain.team.Team;

public class ScoreDto {
    private final String awayName;
    private final Integer awayScore;
    private final String homeName;
    private final Integer homeScore;

    private ScoreDto(Builder builder) {
        this.awayName = builder.awayName;
        this.awayScore = builder.awayScore;
        this.homeName = builder.homeName;
        this.homeScore = builder.homeScore;
    }

    private static class Builder {
        private String awayName;
        private Integer awayScore;
        private String homeName;
        private Integer homeScore;

        private Builder awayName(String awayName) {
            this.awayName = awayName;
            return this;
        }

        private Builder awayScore(Integer awayScore) {
            this.awayScore = awayScore;
            return this;
        }

        private Builder homeName(String homeName) {
            this.homeName = homeName;
            return this;
        }

        private Builder homeScore(Integer homeScore) {
            this.homeScore = homeScore;
            return this;
        }

        private ScoreDto build() {
            return new ScoreDto(this);
        }
    }

    public String getAwayName() {
        return awayName;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public String getHomeName() {
        return homeName;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public static ScoreDto from(Team awayTeam, Team homeTeam) {
        Builder builder = new Builder()
                .awayName(awayTeam.getName())
                .awayScore(awayTeam.totalScore())
                .homeName(homeTeam.getName())
                .homeScore(homeTeam.totalScore());
        return builder.build();
    }

}
