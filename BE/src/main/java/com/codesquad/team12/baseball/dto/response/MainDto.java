package com.codesquad.team12.baseball.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MainDto {
    @JsonProperty
    private List<GameDto> games;

    public MainDto(List<GameDto> games) {
        this.games = games;
    }
}
