package com.team22.baseball.controller;

import com.team22.baseball.domain.Game;
import com.team22.baseball.domain.Player;
import com.team22.baseball.domain.Team;
import com.team22.baseball.dto.request.UpdatePlayerInfoDto;
import com.team22.baseball.dto.response.DetailScore.detailScoreDto;
import com.team22.baseball.dto.response.GameList.GameDto;
import com.team22.baseball.dto.response.PlayerScoreList.PlayerDto;
import com.team22.baseball.dto.response.PlayerScoreList.PlayerScoreDto;
import com.team22.baseball.dto.response.PlayerScoreList.TeamDto;
import com.team22.baseball.dto.response.TeamSelect.NextPlayerInfoDto;
import com.team22.baseball.dto.response.TeamSelect.TeamListDto;
import com.team22.baseball.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        logger.debug("gameService.findAllGame() : {}", gameService.findAllGame());
        return gameService.findAllGame();
    }

    @GetMapping("select_team/{title}")
    @ResponseStatus(HttpStatus.OK)
    private List<TeamListDto> selectGame(@PathVariable String title) throws Exception {

        title = Objects.toString(title, "");

        gameService.updateGameStatusByTitle(title);

        return gameService.getInfoSelectedTeam(title);
    }

    @PutMapping("/update_player")
    @ResponseStatus(HttpStatus.OK)
    private NextPlayerInfoDto updatePlayerInfo(@RequestBody UpdatePlayerInfoDto req) throws Exception {
        int[] scores = gameService.calculatePlayerScore(req);

        gameService.updatePlayerInfo(req.getPlayerName(), scores[0], scores[1], scores[2]);
        gameService.insertTeamScore(req.getTeamName(), req.getRound(), req.getTeamScore());

        // 다음 플레이어에 대한 정보 주기
        Player prevPlayer = gameService.findPlayerByName(req.getPlayerName());

        int prevUniformNumber = prevPlayer.getUniformNumber();
        String teamName = req.getTeamName();

        int nextUniformNumber = ++prevUniformNumber > 10 ? 1 : prevUniformNumber;


        NextPlayerInfoDto response = gameService.findNextPlayerByNumberAndTeamName(nextUniformNumber, teamName);

        return response;

    }

    @GetMapping("/detailScore/{gameID}")
    @ResponseStatus(HttpStatus.OK)
    private List<detailScoreDto> detailScore(@PathVariable Long gameID) {

        return gameService.getDetailScoreOfEachTeam(gameID);
    }

    @GetMapping("/playerList/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    private List<PlayerScoreDto> playerScoreList(@PathVariable Long gameId) throws Exception {

        Game findGame = gameService.findGameById(gameId);
        List<PlayerScoreDto> responseDto = new ArrayList<>();


        for (Team team : findGame.getTeams()) {

            List<PlayerDto> playerDtos = new ArrayList<>();
            TeamDto teamDto = TeamDto.of(team.getName(), team.isHome(), team.isSelected());

            for (Player player : team.getPlayers()) {
                playerDtos.add(PlayerDto.of(player.getUniformNumber(), player.getName(), player.getPlateAppearance(), player.getHits(), player.getOuts()));
            }
            responseDto.add(PlayerScoreDto.of(teamDto, playerDtos));
        }

        return responseDto;
    }

}
