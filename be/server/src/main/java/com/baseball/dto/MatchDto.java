package com.baseball.dto;

import com.baseball.domain.Match;
import com.baseball.domain.Team;

import java.util.Map;

public class MatchDto {
    private final String home;
    private final String away;
    private final String id;

    private MatchDto(Builder builder) {
        this.home = builder.home;
        this.away = builder.away;
        this.id = builder.id;
    }

    private static class Builder {
        private String home;
        private String away;
        private String id;

        private Builder home(String home) {
            this.home = home;
            return this;
        }

        private Builder away(String away) {
            this.away = away;
            return this;
        }

        private Builder id(String id) {
            this.id = id;
            return this;
        }

        private MatchDto build() {
            return new MatchDto(this);
        }
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public String getId() {
        return id;
    }

    public static MatchDto from(Map.Entry<String, Match> entry) {
        String id = entry.getKey();
        Match match = entry.getValue();
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();
        Builder builder = new Builder()
                .home(homeTeam.getName())
                .away(awayTeam.getName())
                .id(id);
        return builder.build();
    }

}
