package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlayingsDto {
    @JsonProperty
    private List<PlayingDto> home;

    @JsonProperty
    private List<PlayingDto> away;

    public PlayingsDto(List<PlayingDto> home, List<PlayingDto> away) {
        this.home = home;
        this.away = away;
    }
}
