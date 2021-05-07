package com.codesquad.baseball.DTO;

import org.springframework.data.relational.core.mapping.Column;

public class GameListDTO {

    @Column("gameId")
    private Long gameId;

    @Column("homeTeamName")
    private String homeTeamName;

    @Column("awayTeamName")
    private String awayTeamName;

    public GameListDTO(Long gameId, String homeTeamName, String awayTeamName) {
        this.gameId = gameId;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }
}
