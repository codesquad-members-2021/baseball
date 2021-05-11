package com.team22.baseball.dto.response.PlayerScoreList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDto {

    @JsonProperty("uniform_number")
    private int uniformNumber;

    @JsonProperty("player_name")
    private String playerName;

    @JsonProperty("plate_appearance")
    private int plateAppearance;

    @JsonProperty("hits")
    private int hits;

    @JsonProperty("outs")
    private int outs;

    public PlayerDto(int uniformNumber, String playerName, int plateAppearance, int hits, int outs) {
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

    public static PlayerDto of(int uniformNumber, String playerName, int plateAppearance, int hits, int outs) {
        return new PlayerDto(uniformNumber, playerName, plateAppearance, hits, outs);
    }
}
