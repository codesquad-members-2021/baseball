package com.team22.baseball.controller;

import com.team22.baseball.dto.request.SelectTeam;
import com.team22.baseball.dto.request.UpdatePlayerInfo;
import com.team22.baseball.dto.response.ApiResult;
import com.team22.baseball.dto.response.DetailScore.DetailScore;
import com.team22.baseball.dto.response.GameList.GameInfo;
import com.team22.baseball.dto.response.PlayerScoreList.ScoreList;
import com.team22.baseball.dto.response.TeamSelect.NextPlayerInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamListDto;
import com.team22.baseball.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApiGameController {

    private final Logger logger = LoggerFactory.getLogger(ApiGameController.class);

    private final GameService gameService;

    @Autowired
    private ApiGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("games")
    private ApiResult<List<GameInfo>> gameList() {
        List<GameInfo> gameInfos = gameService.findAllGame();
        logger.debug("gameService.findAllGame() : {}", gameInfos);

        return ApiResult.succeed(gameInfos);
    }

    @PutMapping("team")
    private List<TeamListDto> selectGame(@RequestBody SelectTeam selectTeam) throws Exception {
        final String teamTitle = selectTeam.getTitle();
        gameService.updateGameStatusByTitle(teamTitle);

        return gameService.getInfoSelectedTeam(teamTitle);
    }

    @PutMapping("player")
    @ResponseStatus(HttpStatus.CREATED)
    private NextPlayerInfoDto updatePlayerInfo(@RequestBody UpdatePlayerInfo updatePlayerInfo) {
        return gameService.updatePlayerInfo(updatePlayerInfo);
    }

    @GetMapping("/detail-score/{gameId}")
    private List<DetailScore> detailScore(@PathVariable Long gameId) {
        return gameService.getDetailScoreOfEachTeam(gameId);
    }

    @GetMapping("/player-list/{gameId}")
    private List<ScoreList> playerScoreList(@PathVariable Long gameId) {
        return gameService.getPlayerScoreOfGame(gameId);
    }

    @PostMapping("/reset/games/{gameId}/reset")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void resetData(@PathVariable Long gameId) {
        gameService.resetGameData(gameId);
    }

}
