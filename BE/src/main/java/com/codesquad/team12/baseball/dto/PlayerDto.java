package com.codesquad.team12.baseball.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDto {
    @JsonProperty
    private Integer number;

    @JsonProperty
    private String name;

    @JsonProperty
    private String position;

    public PlayerDto(Integer number, String name, String position) {
        this.number = number;
        this.name = name;
        this.position = position;
    }
}
