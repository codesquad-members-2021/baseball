package com.codesquad.baseball.controller;

import com.codesquad.baseball.dto.GameDetailDTO;
import com.codesquad.baseball.dto.GamesDTO;
import com.codesquad.baseball.dto.PitchDTO;
import com.codesquad.baseball.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @CrossOrigin
    @GetMapping
    public GamesDTO showGames() {
        return gameService.showGames();
    }

    @CrossOrigin
    @PatchMapping("/{gameId}")
    public void joinIn(@PathVariable("gameId") int gameId) {
        gameService.joinIn(gameId);
    }

    @CrossOrigin
    @GetMapping("/{gameId}")
    public GameDetailDTO showGameDetail(@PathVariable("gameId") int gameId) {
        return gameService.gameDetail(gameId);
    }

    @CrossOrigin
    @PostMapping("/{gameId}/pitch")
    public PitchDTO pitch(@PathVariable("gameId") int gameId) {
        return gameService.doPitch(gameId);
    }
}
