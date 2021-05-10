package com.team22.baseball.dto.request;

public class UpdatePlayerInfoDto {

    private int round;

    private String teamName;

    private int teamScore;

    private String playerName;

    private boolean hit;

    public UpdatePlayerInfoDto(int round, String teamName, int teamScore, String playerName, boolean hit) {
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
