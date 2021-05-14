package baseball.controller;

import baseball.service.TeamService;
import baseball.service.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public void createTeams(@RequestBody List<TeamRequest> teamDTOs) {
        teamService.saveTeams(teamDTOs);
    }

    @GetMapping
    public TeamsDTO showTeams() {
        return teamService.convertToTeamsDTO();
    }

    @PostMapping("/{teamId}/{memberId}/record")
    public void addRecord(@PathVariable Long teamId, @PathVariable Long memberId, @RequestBody RecordRequest recordRequest) {
        teamService.insertRecord(teamId, memberId, recordRequest);
    }
}
