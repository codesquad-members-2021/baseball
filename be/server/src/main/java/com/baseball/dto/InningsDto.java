package com.baseball.dto;

import com.baseball.domain.team.Team;

import java.util.List;

public class InningsDto {

    private final List<Integer> away;
    private final List<Integer> home;

    private InningsDto(Builder builder) {
        this.away = builder.away;
        this.home = builder.home;
    }

    private static class Builder {
        private List<Integer> away;
        private List<Integer> home;

        public Builder away(List<Integer> away) {
            this.away = away;
            return this;
        }

        public Builder home(List<Integer> home) {
            this.home = home;
            return this;
        }

        private InningsDto build() {
            return new InningsDto(this);
        }
    }

    public List<Integer> getAway() {
        return away;
    }

    public List<Integer> getHome() {
        return home;
    }

    public static InningsDto from(Team awayTeam, Team homeTeam) {
        Builder builder = new Builder()
                .away(awayTeam.getScores())
                .home(homeTeam.getScores());
        return builder.build();
    }
}
