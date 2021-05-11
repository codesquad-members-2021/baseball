package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.Team;

import java.util.List;

public class TeamDetailDTO {
    private int id;
    private String teamName;
    private List<PlayerDTO> players;

    public TeamDetailDTO(int id, String teamName, List<PlayerDTO> players) {
        this.id = id;
        this.teamName = teamName;
        this.players = players;
    }

    public static TeamDetailDTO from(Team team, List<PlayerDTO> players) {
        return new TeamDetailDTO(team.getId(), team.getTeamName(), players);
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }
}
