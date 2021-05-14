package com.codesquad.team12.baseball.controller;

import com.codesquad.team12.baseball.dto.response.MainDto;
import com.codesquad.team12.baseball.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/main")
public class MainController {
    private final GameService gameService;

    @Autowired
    public MainController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public MainDto getMain() {
        return new MainDto(gameService.findAll());
    }
}
