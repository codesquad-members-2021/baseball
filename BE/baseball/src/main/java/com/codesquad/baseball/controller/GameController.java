package com.codesquad.baseball.controller;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.DTO.TeamDTO;
import com.codesquad.baseball.DTO.record.TeamRecordDTO;
import com.codesquad.baseball.DTO.record.request.PlayerRecordRequest;
import com.codesquad.baseball.DTO.score.GameScoreDTO;
import com.codesquad.baseball.domain.Score;
import com.codesquad.baseball.service.GameService;
import com.codesquad.baseball.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baseball")
public class GameController {

    private final GameService gameService;
    private final TeamService teamService;

    public GameController(GameService gameService, TeamService teamService) {
        this.gameService = gameService;
        this.teamService = teamService;
    }

    @GetMapping("/games")
    public List<GameListDTO> browseGames() {
        return gameService.browseAllGames();
    }

    @GetMapping("/games/{teamId}")
    public TeamDTO browseTeamStatus(@PathVariable Long teamId) {
        return teamService.browseTeamStatus(teamId);
    }

    @GetMapping("/play/{gameId}/players")
    public TeamRecordDTO browseTeamPlayers(@PathVariable Long gameId) {
        return gameService.browseTeamPlayersByGameId(gameId);
    }

    @PostMapping("/play/{teamId}/score")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addScore(@PathVariable Long teamId, @RequestBody Score score) {
        teamService.addScore(teamId, score);
    }

    @GetMapping("/play/{gameId}/score")
    public GameScoreDTO browseAllScore(@PathVariable Long gameId) {
        return gameService.browseGameScoreByGameId(gameId);
    }

    @PatchMapping("/play/{teamId}/record")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayerRecord(@PathVariable Long teamId, @RequestBody PlayerRecordRequest record) {
        teamService.updatePlayerRecord(teamId, record);
    }
}
