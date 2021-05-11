package com.codesquad.team12.baseball.dto;

import com.codesquad.team12.baseball.model.Inning;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScoreTeamDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private List<Inning> innings;

    public ScoreTeamDto(String teamName, List<Inning> innings) {
        this.teamName = teamName;
        this.innings = innings;
    }
}
