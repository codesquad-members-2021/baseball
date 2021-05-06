package com.codesquad.coco.team;

import com.codesquad.coco.team.domain.MainTeamDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/main")
    public MainTeamDTO mainPage() {
        return teamService.findMainTeams();
    }
}
