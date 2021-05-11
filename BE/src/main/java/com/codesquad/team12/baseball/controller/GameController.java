package com.codesquad.team12.baseball.controller;

import com.codesquad.team12.baseball.dto.GameInitDto;
import com.codesquad.team12.baseball.dto.ScoreDto;
import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.service.GameService;
import com.codesquad.team12.baseball.service.InningService;
import com.codesquad.team12.baseball.service.PlayingService;
import com.codesquad.team12.baseball.service.TeamService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/games/{gameId}")
public class GameController {
    private final GameService gameService;
    private final TeamService teamService;
    private final PlayingService playingService;
    private final InningService inningService;

    public GameController(GameService gameService, TeamService teamService, PlayingService playingService, InningService inningService) {
        this.gameService = gameService;
        this.teamService = teamService;
        this.playingService = playingService;
        this.inningService = inningService;
    }

    @GetMapping
    public GameInitDto getGame(@PathVariable Long gameId) {
        Game game = gameService.findById(gameId);
        inningService.initInning(gameId, game.getHomeName());
        inningService.initInning(gameId, game.getAwayName());
        playingService.initPlaying(gameId, game.getHomeName());
        playingService.initPlaying(gameId, game.getAwayName());

        return new GameInitDto(teamService.findById(game.getHomeName()),
                teamService.findById(game.getAwayName()));
    }

    @GetMapping("/scores")
    public ScoreDto getScores(@PathVariable Long gameId, @PathVariable String teamName) {
        Game game = gameService.findById(gameId);
        return Game.createScoreDto(game);
    }

    @GetMapping("/players")
    public void getPlayers(@PathVariable Long gameId) {
    }

    @PutMapping
    public void putGame(@PathVariable Long gameId) {
//        TODO: To get parameter from request body using DTO
    }

    @PutMapping("/{teamId}")
    public void putPlaying(@PathVariable Long gameId, @PathVariable Long teamId) {
    }
}
