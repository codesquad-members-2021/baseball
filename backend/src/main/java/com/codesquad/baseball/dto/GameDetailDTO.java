package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.Game;

public class GameDetailDTO {
    private TeamDetailDTO homeTeam;
    private TeamDetailDTO awayTeam;
    private GameStatusDTO gameStatusDTO;

    public GameDetailDTO(TeamDetailDTO homeTeam, TeamDetailDTO awayTeam, GameStatusDTO gameStatusDTO) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameStatusDTO = gameStatusDTO;
    }

    public static GameDetailDTO from(TeamDetailDTO homeTeam, TeamDetailDTO awayTeam, Game game) {
        return new GameDetailDTO(homeTeam, awayTeam, GameStatusDTO.from(game));
    }

    public TeamDetailDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamDetailDTO getAwayTeam() {
        return awayTeam;
    }

    public GameStatusDTO getGameStatus() {
        return gameStatusDTO;
    }
}
