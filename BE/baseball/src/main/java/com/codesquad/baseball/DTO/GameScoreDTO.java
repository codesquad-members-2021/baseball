package com.codesquad.baseball.DTO;

import com.codesquad.baseball.domain.Game;

public class GameScoreDTO {

    private Long gameId;

    private TeamScoreDTO homeTeam;

    private TeamScoreDTO awayTeam;

    public static GameScoreDTO of(Game game, TeamScoreDTO homeTeam, TeamScoreDTO awayTeam) {
        return new GameScoreDTO(
                game.getId(),
                homeTeam,
                awayTeam
        );
    }

    private GameScoreDTO(Long gameId, TeamScoreDTO homeTeam, TeamScoreDTO awayTeam) {
        this.gameId = gameId;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Long getGameId() {
        return gameId;
    }

    public TeamScoreDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamScoreDTO getAwayTeam() {
        return awayTeam;
    }
}
