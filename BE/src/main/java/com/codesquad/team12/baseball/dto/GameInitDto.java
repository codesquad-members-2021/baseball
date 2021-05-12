package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameInitDto {
    @JsonProperty
    private TeamPlayerDto home;

    @JsonProperty
    private TeamPlayerDto away;

    public GameInitDto(TeamPlayerDto home, TeamPlayerDto away) {
        this.home = home;
        this.away = away;
    }
}
