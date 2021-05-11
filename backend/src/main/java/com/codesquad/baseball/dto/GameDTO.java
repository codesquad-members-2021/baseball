package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.domain.Team;

public class GameDTO {
    private Integer id;
    private boolean occupied;
    private String gameTitle;
    private TeamDTO homeTeam;
    private TeamDTO awayTeam;

    protected GameDTO() {
    }

    public GameDTO(Builder builder) {
        this.id = builder.id;
        this.occupied = builder.occupied;
        this.gameTitle = builder.gameTitle;
        this.homeTeam = builder.homeTeam;
        this.awayTeam = builder.awayTeam;
    }

    public static GameDTO from(Game game, Team homeTeam, Team awayTeam) {
        return new Builder()
                .id(game.getId())
                .gameTitle(game.getGameTitle())
                .homeTeam(TeamDTO.from(homeTeam))
                .awayTeam(TeamDTO.from(awayTeam))
                .build();
    }

    public Integer getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public TeamDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamDTO getAwayTeam() {
        return awayTeam;
    }

    public static class Builder {
        private Integer id;
        private boolean occupied;
        private String gameTitle;
        private TeamDTO homeTeam;
        private TeamDTO awayTeam;

        public Builder id(Integer value) {
            id = value;
            return this;
        }

        public Builder occupied(boolean value) {
            occupied = value;
            return this;
        }

        public Builder gameTitle(String value) {
            gameTitle = value;
            return this;
        }

        public Builder homeTeam(TeamDTO value) {
            homeTeam = value;
            return this;
        }

        public Builder awayTeam(TeamDTO value) {
            awayTeam = value;
            return this;
        }

        public GameDTO build() {
            return new GameDTO(this);
        }
    }
}
