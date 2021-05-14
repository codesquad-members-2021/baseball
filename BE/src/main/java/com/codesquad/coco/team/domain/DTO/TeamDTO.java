package com.codesquad.coco.team.domain.DTO;

import com.codesquad.coco.player.domain.model.DTO.PlayerDTO;

import java.util.List;

public class TeamDTO {

    private String teamName;
    private List<PlayerDTO> players;

    public TeamDTO(String teamName, List<PlayerDTO> players) {
        this.teamName = teamName;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }
}
