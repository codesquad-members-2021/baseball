package com.codesquad.team12.baseball.dto.response;

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
