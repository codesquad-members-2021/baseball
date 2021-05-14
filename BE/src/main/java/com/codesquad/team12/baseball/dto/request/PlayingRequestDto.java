package com.codesquad.team12.baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayingRequestDto {
    @JsonProperty
    private String teamName;

    @JsonProperty
    private Integer playerNumber;

    @JsonProperty
    private String playerName;

    @JsonProperty
    private Integer pa;

    @JsonProperty
    private Integer hit;

    @JsonProperty
    private Integer out;

    public PlayingRequestDto(String teamName, Integer playerNumber, String playerName, Integer pa, Integer hit, Integer out) {
        this.teamName = teamName;
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.pa = pa;
        this.hit = hit;
        this.out = out;
    }

    public String getTeamName() {
        return teamName;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getPa() {
        return pa;
    }

    public Integer getHit() {
        return hit;
    }

    public Integer getOut() {
        return out;
    }
}
