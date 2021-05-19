package com.team22.baseball.dto.response.GameList;


public class GameInfo {

    private Long gameId;

    private boolean inProgress;

    private String home;

    private String away;

    public GameInfo(Long gameId, boolean inProgress, String home, String away) {
        this.gameId = gameId;
        this.inProgress = inProgress;
        this.home = home;
        this.away = away;
    }

    public Long getGameId() {
        return gameId;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setAway(String away) {
        this.away = away;
    }
}
