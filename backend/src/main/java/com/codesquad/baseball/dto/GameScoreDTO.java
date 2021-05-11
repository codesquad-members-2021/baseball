package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

public class GameScoreDTO {

    private int homeTeamScore;
    private int awayTeamScore;
    private List<InningScoreDTO> innings;

    public GameScoreDTO(int homeTeamScore, int awayTeamScore, List<InningScoreDTO> innings) {
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.innings = innings;
    }

    public static GameScoreDTO from(Game game) {
        List<InningScoreDTO> inningScoreDTOS = game.getInnings().stream()
                .map(inning -> new InningScoreDTO.Builder()
                        .inning(inning.getInningNumber())
                        .homeTeamScore(inning.getHomeTeamScore())
                        .awayTeamScore(inning.getAwayTeamScore())
                        .build())
                .collect(Collectors.toList());
        return new GameScoreDTO(game.homeTeamScore(), game.awayTeamScore(), inningScoreDTOS);
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public List<InningScoreDTO> getInnings() {
        return innings;
    }

    public static class InningScoreDTO {
        private int inning;
        private int homeTeamScore;
        private int awayTeamScore;

        public InningScoreDTO(Builder builder) {
            this.inning = builder.inning;
            this.homeTeamScore = builder.homeTeamScore;
            this.awayTeamScore = builder.awayTeamScore;
        }

        public int getInning() {
            return inning;
        }

        public int getHomeTeamScore() {
            return homeTeamScore;
        }

        public int getAwayTeamScore() {
            return awayTeamScore;
        }

        public static class Builder {
            private int inning;
            private int homeTeamScore;
            private int awayTeamScore;

            public Builder inning(int value) {
                inning = value;
                return this;
            }

            public Builder homeTeamScore(int value) {
                homeTeamScore = value;
                return this;
            }

            public Builder awayTeamScore(int value) {
                awayTeamScore = value;
                return this;
            }

            public InningScoreDTO build() {
                return new InningScoreDTO(this);
            }
        }
    }
}
