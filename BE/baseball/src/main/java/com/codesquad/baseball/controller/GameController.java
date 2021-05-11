package com.codesquad.baseball.controller;

import com.codesquad.baseball.DTO.GameListDTO;
import com.codesquad.baseball.DTO.GameStatusDTO;
import com.codesquad.baseball.DTO.TeamDTO;
import com.codesquad.baseball.DTO.TeamRecordDTO;
import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.domain.Team;
import com.codesquad.baseball.service.GameService;
import com.codesquad.baseball.service.TeamService;
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
        Game game = gameService.findGameById(gameId);
        Team homeTeam = teamService.browseTeamById(game.getHomeTeamId());
        Team awayTeam = teamService.browseTeamById(game.getAwayTeamId());
        return new TeamRecordDTO(homeTeam, awayTeam);
    }

    @PostMapping("/play/{teamId}/score")
    public void addScore(@PathVariable Long teamId, @RequestBody Score score) {
        teamService.addScore(teamId, score);
    }

    @GetMapping("/play/{gameId}/score")
    public GameScoreDTO browseAllScore(@PathVariable Long gameId) {
        Game game = gameService.findGameById(gameId);
        TeamScoreDTO homeTeamScoreDTO = teamService.browseTeamScore(game.getHomeTeamId());
        TeamScoreDTO awayTeamScoreDTO = teamService.browseTeamScore(game.getAwayTeamId());
        return GameScoreDTO.of(game, homeTeamScoreDTO, awayTeamScoreDTO);
    }
}
