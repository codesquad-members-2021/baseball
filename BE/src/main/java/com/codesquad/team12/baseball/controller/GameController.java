package com.codesquad.team12.baseball.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games/{gameId}")
public class GameController {

    @GetMapping
    public void getGame(@PathVariable Long gameId) {
    }

    @GetMapping("/scores")
    public void getScores(@PathVariable Long gameId) {
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
