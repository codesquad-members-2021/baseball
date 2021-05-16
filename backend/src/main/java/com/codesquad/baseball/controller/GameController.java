package com.codesquad.baseball.controller;

import com.codesquad.baseball.config.annotation.CertifiedUser;
import com.codesquad.baseball.domain.user.User;
import com.codesquad.baseball.dto.game.GameDetailDTO;
import com.codesquad.baseball.dto.game.GamesDTO;
import com.codesquad.baseball.dto.game.PitchDTO;
import com.codesquad.baseball.service.GameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public GamesDTO showGames() {
        return gameService.showGames();
    }

    @PatchMapping("/{gameId}")
    public void joinIn(@PathVariable("gameId") int gameId, @CertifiedUser User certifiedUser) {
        gameService.joinIn(gameId, certifiedUser);
    }

    @GetMapping("/{gameId}")
    public GameDetailDTO showGameDetail(@PathVariable("gameId") int gameId) {
        return gameService.gameDetail(gameId);
    }

    @PostMapping("/{gameId}/pitch")
    public PitchDTO pitch(@PathVariable("gameId") int gameId, @CertifiedUser User certifiedUser) {
        return gameService.doPitch(gameId, certifiedUser);
    }
}
