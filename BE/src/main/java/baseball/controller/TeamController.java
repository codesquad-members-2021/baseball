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
    public void createTeams(@RequestBody List<RequestTeamDTO> teamDTOs) {
        teamService.saveTeams(teamDTOs);
    }

    @GetMapping
    public List<TeamDTO> showTeams() {
        return teamService.convertToTeamDTOList();
    }

    @PostMapping("/{teamId}/{memberId}/record")
    public void addRecord(@PathVariable Long teamId, @PathVariable Long memberId, @RequestBody RequestRecordDTO recordDTO) {
        teamService.insertRecord(teamId, memberId, recordDTO.getAtBat(), recordDTO.getHit(), recordDTO.getOut());
    }

    @GetMapping("/{teamId}/records")
    public TeamRecordsDTO showRecords(@PathVariable Long teamId) {
        return teamService.getRecordsOfTeam(teamId);
    }
}
