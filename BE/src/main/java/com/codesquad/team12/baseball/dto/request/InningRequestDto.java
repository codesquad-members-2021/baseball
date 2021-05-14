package com.codesquad.team12.baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InningRequestDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private Integer number;

    @JsonProperty
    private Integer score;

    public InningRequestDto(String teamName, Integer number, Integer score) {
        this.teamName = teamName;
        this.number = number;
        this.score = score;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getScore() {
        return score;
    }

}
