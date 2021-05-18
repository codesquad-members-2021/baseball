package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.domain.Team;

public class GameStatusDTO {

    private Long gameId;

    private boolean homeTeamStatus;

    private boolean awayTeamStatus;

    private GameStatusDTO(Long gameId, boolean homeTeamStatus, boolean awayTeamStatus) {
        this.gameId = gameId;
        this.homeTeamStatus = homeTeamStatus;
        this.awayTeamStatus = awayTeamStatus;
    }

    public static GameStatusDTO of(Game game, Team homeTeam, Team awayTeam) {
        return new GameStatusDTO(game.getId(), homeTeam.isPlayable(), awayTeam.isPlayable());
    }

    public Long getGameId() {
        return gameId;
    }

    public boolean isHomeTeamStatus() {
        return homeTeamStatus;
    }

    public boolean isAwayTeamStatus() {
        return awayTeamStatus;
    }
}
