package com.dong.baseball.Controller;

import com.dong.baseball.Domain.Match;
import com.dong.baseball.Service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {


    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public List<Match> allMatches() {
        return gameService.findAllMatches();
    }

    @GetMapping("/{matchId}")
    public

}
