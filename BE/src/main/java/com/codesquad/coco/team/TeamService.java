package com.codesquad.coco.team;

import com.codesquad.coco.team.domain.MainTeamDTO;
import com.codesquad.coco.team.domain.TeamDAO;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamDAO teamDAO;

    public TeamService(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    public MainTeamDTO findMainTeams() {
        return teamDAO.findAllName();
    }
}
