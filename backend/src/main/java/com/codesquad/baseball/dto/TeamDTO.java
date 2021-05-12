package com.codesquad.baseball.dto;

import com.codesquad.baseball.domain.team.Team;

public class TeamDTO {
    private int id;
    private String teamName;

    public TeamDTO(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public static TeamDTO from(Team team) {
        return new TeamDTO(team.getId(), team.getTeamName());
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }
}
