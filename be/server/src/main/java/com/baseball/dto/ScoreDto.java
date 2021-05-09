package com.baseball.dto;

import com.baseball.domain.Team;

public class ScoreDto {
    private final Integer awayScore;
    private final Integer homeScore;

    private ScoreDto(Builder builder) {
        this.awayScore = builder.awayScore;
        this.homeScore = builder.homeScore;
    }

    private static class Builder {
        private Integer awayScore;
        private Integer homeScore;

        private Builder awayScore(Integer awayScore) {
            this.awayScore = awayScore;
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

    public Integer getAwayScore() {
        return awayScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public static ScoreDto from(Team awayTeam, Team homeTeam) {
        Builder builder = new Builder()
                .awayScore(awayTeam.totalScore())
                .homeScore(homeTeam.totalScore());
        return builder.build();
    }

}
