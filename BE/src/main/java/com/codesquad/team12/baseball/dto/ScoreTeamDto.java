package com.codesquad.team12.baseball.dto;

import com.codesquad.team12.baseball.model.Inning;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScoreTeamDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private List<InningDto> innings;

    public ScoreTeamDto(String teamName, List<InningDto> innings) {
        this.teamName = teamName;
        this.innings = innings;
    }
}
