package com.team22.baseball.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePlayerInfo {


    private int round;

    private String teamName;

    private int teamScore;

    private String playerName;

    private boolean hit;

    @JsonCreator
    public UpdatePlayerInfo(@JsonProperty("round") int round, @JsonProperty("teamName") String teamName, @JsonProperty("teamScore") int teamScore, @JsonProperty("playerName") String playerName, @JsonProperty("hit") boolean hit) {
        this.round = round;
        this.teamName = teamName;
        this.teamScore = teamScore;
        this.playerName = playerName;
        this.hit = hit;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
