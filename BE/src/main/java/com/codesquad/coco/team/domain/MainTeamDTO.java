package com.codesquad.coco.team.domain;

import java.util.ArrayList;
import java.util.List;

public class MainTeamDTO {

    private List<TeamDTO> teams = new ArrayList<>();

    public void addTeamDTO(TeamDTO teamDTO) {
        teams.add(teamDTO);
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

}
