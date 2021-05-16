package com.team22.baseball.dto.response.PlayerScoreList;

public class PlayerInfo {

    private int uniformNumber;

    private String playerName;

    private int plateAppearance;

    private int hits;

    private int outs;

    public PlayerInfo(int uniformNumber, String playerName, int plateAppearance, int hits, int outs) {
        this.uniformNumber = uniformNumber;
        this.playerName = playerName;
        this.plateAppearance = plateAppearance;
        this.hits = hits;
        this.outs = outs;
    }

    public int getUniformNumber() {
        return uniformNumber;
    }

    public void setUniformNumber(int uniformNumber) {
        this.uniformNumber = uniformNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlateAppearance() {
        return plateAppearance;
    }

    public void setPlateAppearance(int plateAppearance) {
        this.plateAppearance = plateAppearance;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    public static PlayerInfo of(int uniformNumber, String playerName, int plateAppearance, int hits, int outs) {
        return new PlayerInfo(uniformNumber, playerName, plateAppearance, hits, outs);
    }
}
