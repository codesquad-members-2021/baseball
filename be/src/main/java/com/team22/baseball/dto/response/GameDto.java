package com.team22.baseball.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDto {

    @JsonProperty("game_id")
    private Long gameId;

    @JsonProperty("home")
    private String home;

    @JsonProperty("home_selected")
    private boolean homeSelected;

    @JsonProperty("away")
    private String away;

    @JsonProperty("away_selected")
    private boolean awaySelected;

    public GameDto(Long gameId, String home, boolean homeSelected, String away, boolean awaySelected) {
        this.gameId = gameId;
        this.home = home;
        this.homeSelected = homeSelected;
        this.away = away;
        this.awaySelected = awaySelected;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public boolean isHomeSelected() {
        return homeSelected;
    }

    public void setHomeSelected(boolean homeSelected) {
        this.homeSelected = homeSelected;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public boolean isAwaySelected() {
        return awaySelected;
    }

    public void setAwaySelected(boolean awaySelected) {
        this.awaySelected = awaySelected;
    }
}
