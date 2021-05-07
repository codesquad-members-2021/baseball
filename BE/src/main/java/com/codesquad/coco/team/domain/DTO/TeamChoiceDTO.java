package com.codesquad.coco.team.domain.DTO;

public class TeamChoiceDTO {

    private String user;
    private String opponent;

    public TeamChoiceDTO(String user, String opponent) {
        this.user = user;
        this.opponent = opponent;
    }

    public String getUser() {
        return user;
    }

    public String getOpponent() {
        return opponent;
    }
}
