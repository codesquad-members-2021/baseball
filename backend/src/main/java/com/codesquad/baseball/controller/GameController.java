package com.codesquad.baseball.controller;

import com.codesquad.baseball.dto.GamesDTO;
import com.codesquad.baseball.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
