package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDto {
    @JsonProperty
    private Long gameId;

    @JsonProperty
    private TeamDto home;

    @JsonProperty
    private TeamDto away;

    public GameDto(Long gameId, TeamDto home, TeamDto away) {
        this.gameId = gameId;
        this.home = home;
        this.away = away;
    }
}
