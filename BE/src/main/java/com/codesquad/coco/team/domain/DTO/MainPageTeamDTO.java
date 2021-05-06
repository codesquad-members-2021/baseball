package com.codesquad.coco.team.domain.DTO;

import java.util.ArrayList;
import java.util.List;

public class MainPageTeamDTO {

    private List<TeamNameDTO> teams = new ArrayList<>();

    public void addTeamDTO(TeamNameDTO teamNameDTO) {
        teams.add(teamNameDTO);
    }

    public List<TeamNameDTO> getTeams() {
        return teams;
    }

}
