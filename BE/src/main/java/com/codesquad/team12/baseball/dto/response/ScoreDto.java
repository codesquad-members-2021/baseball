package com.codesquad.team12.baseball.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

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
