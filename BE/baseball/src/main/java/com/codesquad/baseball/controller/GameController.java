package com.codesquad.baseball.controller;

import com.codesquad.baseball.domain.Game;
import com.codesquad.baseball.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/baseball")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public List<Game> browseGames() {
        return gameService.browseAllGames();
    }
}
