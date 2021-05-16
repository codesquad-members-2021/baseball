package com.codesquad.baseball.controller;

import com.codesquad.baseball.annotation.Auth;
import com.codesquad.baseball.dto.game.GameDetailDTO;
import com.codesquad.baseball.dto.game.GamesDTO;
import com.codesquad.baseball.dto.game.PitchDTO;
import com.codesquad.baseball.service.GameService;
import com.codesquad.baseball.utils.ControllerUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public void joinIn(@PathVariable("gameId") int gameId, HttpServletRequest request) {
        String userId = ControllerUtil.extractUserIdFromRequest(request);
        gameService.joinIn(gameId, userId);
    }

    @GetMapping("/{gameId}")
    public GameDetailDTO showGameDetail(@PathVariable("gameId") int gameId) {
        return gameService.gameDetail(gameId);
    }

    @PostMapping("/{gameId}/pitch")
    public PitchDTO pitch(@PathVariable("gameId") int gameId, HttpServletRequest request) {
        String userId = ControllerUtil.extractUserIdFromRequest(request);
        return gameService.doPitch(gameId, userId);
    }
}
