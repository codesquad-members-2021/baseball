package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private boolean isPlaying;

    public TeamDto(String teamName, boolean isPlaying) {
        this.teamName = teamName;
        this.isPlaying = isPlaying;
    }
}
