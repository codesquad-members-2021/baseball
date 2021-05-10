package com.codesquad.coco.game;

import com.codesquad.coco.game.domain.model.DTO.GamePlayDTO;
import com.codesquad.coco.game.domain.model.DTO.GameScoreDTO;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.team.TeamService;
import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamChoiceDTO;
import com.codesquad.coco.team.domain.DTO.TeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamPointDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private TeamService teamService;
    private GameService gameService;

    public GameController(TeamService teamService, GameService gameService) {
        this.teamService = teamService;
        this.gameService = gameService;
    }

    @GetMapping("/intro")
    @ResponseStatus(HttpStatus.OK)
    public MainPageTeamDTO mainPage() {
        return teamService.findMainTeams();
    }

    @PostMapping("/games/type-home")
    @ResponseStatus(HttpStatus.CREATED)
    public GamePlayDTO homeTeamMatch(@RequestBody TeamChoiceDTO choiceDTO) {
        return teamService.makeHomeGameDTO(choiceDTO);
    }

    @PostMapping("/games/type-away")
    @ResponseStatus(HttpStatus.CREATED)
    public GamePlayDTO awayTeamMatch(@RequestBody TeamChoiceDTO choiceDTO) {
        return teamService.makeAwayGameDTO(choiceDTO);
    }

    @PostMapping("/games/{gameId}/points")
    @ResponseStatus(HttpStatus.OK)
    public void plusPoint(@PathVariable Long gameId, @RequestBody TeamPointDTO teamPointDTO) {
        ScoreBoard scoreBoard = gameService.findScoreBoardByTeamName(gameId, teamPointDTO);
        gameService.plusPoint(scoreBoard, teamPointDTO);
    }

    @GetMapping("/games/{gameId}/points")
    @ResponseStatus(HttpStatus.OK)
    public GameScoreDTO gamePoint(@PathVariable Long gameId) {
        return gameService.findGameScoreDTOByGameId(gameId);
    }

    @GetMapping("/games/{gameId}/players")
    @ResponseStatus(HttpStatus.OK)
    public GamePlayDTO showPlayer(@PathVariable Long gameId) {
        String userTeamName = gameService.findUserTeamNameByGameId(gameId);

        TeamDTO homeTeam = teamService.findHomeTeamByGameId(gameId);
        TeamDTO awayTeam = teamService.findAwayTeamByGameId(gameId);

        if (homeTeam.getTeamName().equals(userTeamName)) {
            return new GamePlayDTO(gameId, homeTeam, awayTeam);
        }
        return new GamePlayDTO(gameId, awayTeam, homeTeam);
    }

}
