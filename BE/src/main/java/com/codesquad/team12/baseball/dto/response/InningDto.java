package com.codesquad.team12.baseball.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InningDto {
    @JsonProperty
    private Integer number;

    @JsonProperty
    private Integer score;

    public InningDto(Integer number, Integer score) {
        this.number = number;
        this.score = score;
    }
}
