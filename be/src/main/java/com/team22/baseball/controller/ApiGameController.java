package com.team22.baseball.controller;

import com.team22.baseball.dto.response.GameDto;
import com.team22.baseball.dto.response.TeamListDto;
import com.team22.baseball.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/")
public class ApiGameController {

    private final Logger logger = LoggerFactory.getLogger(ApiGameController.class);

    private GameService gameService;

    @Autowired
    private ApiGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("game_list")
    private List<GameDto> gameList() {
        logger.debug("gameService.findAllGame() : {}",gameService.findAllGame());
        return gameService.findAllGame();
    }

    @GetMapping("select_team/{title}")
    @ResponseStatus(HttpStatus.OK)
    private List<TeamListDto> selectGame(@PathVariable String title) throws Exception {

        title = Objects.toString(title,"");

        gameService.updateSelectedTeamByTitle(title);

        return gameService.getInfoSelectedTeam(title);
    }


}
