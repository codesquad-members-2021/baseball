package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamPlayerDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private List<PlayerDto> players;

    public TeamPlayerDto(String teamName, List<PlayerDto> players) {
        this.teamName = teamName;
        this.players = players;
    }
}
