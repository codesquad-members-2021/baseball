package com.codesquad.coco.team.domain.DTO;

public class TeamChoiceDTO {

    private String player;
    private String opponent;

    public TeamChoiceDTO(String player, String opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public String getPlayer() {
        return player;
    }

    public String getOpponent() {
        return opponent;
    }
}
