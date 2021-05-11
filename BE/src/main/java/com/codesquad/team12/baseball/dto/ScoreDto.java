package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScoreDto {
    @JsonProperty
    private ScoreTeamDto home;

    @JsonProperty
    private ScoreTeamDto away;

    public ScoreDto(ScoreTeamDto home, ScoreTeamDto away) {
        this.home = home;
        this.away = away;
    }
}
