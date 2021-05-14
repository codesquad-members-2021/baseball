package com.codesquad.team12.baseball.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayingDto {
    @JsonProperty
    private String player;

    @JsonProperty
    private String position;

    @JsonProperty
    private Integer pa;

    @JsonProperty
    private Integer hit;

    @JsonProperty
    private Integer out;

    @JsonProperty
    private Double average;

    public PlayingDto(String player, String position, Integer pa, Integer hit, Integer out, Double average) {
        this.player = player;
        this.position = position;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
        this.average = average;
    }
}
