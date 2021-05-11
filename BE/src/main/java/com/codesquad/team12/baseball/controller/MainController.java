package com.codesquad.team12.baseball.controller;

import com.codesquad.team12.baseball.dto.GameDto;
import com.codesquad.team12.baseball.dto.MainDto;
import com.codesquad.team12.baseball.model.Game;
import com.codesquad.team12.baseball.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
