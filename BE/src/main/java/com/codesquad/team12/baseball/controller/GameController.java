package com.codesquad.team12.baseball.controller;

import com.codesquad.team12.baseball.dto.*;
import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.service.GameService;
import com.codesquad.team12.baseball.service.InningService;
import com.codesquad.team12.baseball.service.PlayingService;
import com.codesquad.team12.baseball.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ScoreDto getScores(@PathVariable Long gameId) {
        Game game = gameService.findById(gameId);

        List<InningDto> homeInnings = inningService.findAllByTeam(gameId, game.getHomeName());
        List<InningDto> awayInnings = inningService.findAllByTeam(gameId, game.getAwayName());

        ScoreTeamDto home = new ScoreTeamDto(game.getHomeName(), homeInnings);
        ScoreTeamDto away = new ScoreTeamDto(game.getAwayName(), awayInnings);

        return new ScoreDto(home, away);
    }

    @GetMapping("/squads")
    public PlayingsDto getPlayers(@PathVariable Long gameId) {
        Game game = gameService.findById(gameId);

        List<PlayingDto> homePlayings = playingService.findAllByTeam(gameId, game.getHomeName());
        List<PlayingDto> awayPlayings = playingService.findAllByTeam(gameId, game.getAwayName());

        return new PlayingsDto(homePlayings, awayPlayings);
    }

    @PutMapping("/innings")
    public void putGame(@PathVariable Long gameId, @RequestBody InningRequestDto inningRequestDto) {
        inningService.updateInning(gameId, inningRequestDto);
    }

    @PutMapping("/{teamId}")
    public void putPlaying(@PathVariable Long gameId, @PathVariable Long teamId) {
    }
}
