package com.codesquad.baseball.controller;

import com.codesquad.baseball.DTO.TeamDTO;
import com.codesquad.baseball.DTO.record.request.PlayerRecordRequest;
import com.codesquad.baseball.domain.Score;
import com.codesquad.baseball.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baseball")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/games/{teamId}")
    public TeamDTO browseTeamStatus(@PathVariable Long teamId) {
        return teamService.browseTeamStatus(teamId);
    }

    @PostMapping("/play/{teamId}/score")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addScore(@PathVariable Long teamId, @RequestBody Score score) {
        teamService.addScore(teamId, score);
    }

    @PatchMapping("/play/{teamId}/record")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayerRecord(@PathVariable Long teamId, @RequestBody PlayerRecordRequest record) {
        teamService.updatePlayerRecord(teamId, record);
    }
}
