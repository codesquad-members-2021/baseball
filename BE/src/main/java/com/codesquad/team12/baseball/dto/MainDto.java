package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class MainDto {
    @JsonProperty
    private Set<GameDto> games;

    public MainDto(Set<GameDto> games) {
        this.games = games;
    }
}
