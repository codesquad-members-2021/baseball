package com.codesquad.coco.team.domain.DTO;

public class GamePlayDTO {

    private Long gameId;

    private TeamDTO user;
    private TeamDTO opponent;

    public GamePlayDTO(Long gameId, TeamDTO user, TeamDTO opponent) {
        this.gameId = gameId;
        this.user = user;
        this.opponent = opponent;
    }

    public Long getGameId() {
        return gameId;
    }

    public TeamDTO getUser() {
        return user;
    }

    public TeamDTO getOpponent() {
        return opponent;
    }
}
