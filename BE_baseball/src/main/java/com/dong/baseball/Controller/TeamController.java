package com.dong.baseball.Controller;

import com.dong.baseball.DTO.TeamRankDTO;
import com.dong.baseball.Domain.Team;
import com.dong.baseball.Service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamRankDTO> teamRanking() {
        return teamService.teamRanking();
    }

    @GetMapping("/num/{teamId}")
    public Team teamInfoById(@PathVariable Long teamId) {
        return teamService.teamInfoById(teamId);
    }

    @GetMapping("/{teamName}")
    public Team teamInfoByName(@PathVariable String teamName) {
        return teamService.teamInfoByName(teamName);
    }
}
