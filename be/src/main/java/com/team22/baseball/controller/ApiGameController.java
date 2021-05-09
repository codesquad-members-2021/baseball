package com.team22.baseball.controller;

import com.team22.baseball.dto.response.GameDto;
import com.team22.baseball.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class ApiGameController {

    private final Logger logger = LoggerFactory.getLogger(ApiGameController.class);

    private GameService gameService;

    @Autowired
    private ApiGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("game_list")
    @ResponseStatus(HttpStatus.OK)
    private List<GameDto> gameList(){
        return gameService.findAllGame();
    }

}
