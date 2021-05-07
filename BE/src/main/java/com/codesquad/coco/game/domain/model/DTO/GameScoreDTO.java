package com.codesquad.coco.game.domain.model.DTO;

import com.codesquad.coco.team.domain.DTO.TeamScoreDTO;

public class GameScoreDTO {

    private TeamScoreDTO user;
    private TeamScoreDTO opponent;

    public GameScoreDTO(TeamScoreDTO user, TeamScoreDTO opponent) {
        this.user = user;
        this.opponent = opponent;
    }

    public TeamScoreDTO getUser() {
        return user;
    }

    public TeamScoreDTO getOpponent() {
        return opponent;
    }
}
