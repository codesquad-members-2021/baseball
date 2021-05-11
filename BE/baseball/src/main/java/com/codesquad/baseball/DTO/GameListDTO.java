package com.codesquad.baseball.DTO;

import org.springframework.data.relational.core.mapping.Column;

public class GameListDTO {

    @Column("gameId")
    private Long gameId;

    @Column("homeTeamName")
    private String homeTeamName;

    @Column("homeTeamId")
    private Long homeTeamId;

    @Column("awayTeamName")
    private String awayTeamName;

    @Column("awayTeamId")
    private Long awayTeamId;

    public GameListDTO(Long gameId, String homeTeamName, Long homeTeamId, String awayTeamName, Long awayTeamId) {
        this.gameId = gameId;
        this.homeTeamName = homeTeamName;
        this.homeTeamId = homeTeamId;
        this.awayTeamName = awayTeamName;
        this.awayTeamId = awayTeamId;
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

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
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

    public void setHomeTeamId(Long homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setAwayTeamId(Long awayTeamId) {
        this.awayTeamId = awayTeamId;
    }
}
