package com.codesquad.coco.game;

import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.game.domain.model.GamePlayDTO;
import com.codesquad.coco.game.domain.model.GameScoreDTO;
import com.codesquad.coco.game.domain.model.ScoreBoard;
import com.codesquad.coco.team.TeamService;
import com.codesquad.coco.team.domain.DTO.*;
import com.codesquad.coco.utils.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Long gameId = teamService.makeHomeGame(choiceDTO);
        Game game = gameService.choiceGame(gameId);

        TeamDTO homeTeam = DTOConverter.teamToDTO(game.getHome());
        TeamDTO awayTeam = DTOConverter.teamToDTO(game.getAway());

        return new GamePlayDTO(gameId, homeTeam, awayTeam);

    }

    @PostMapping("/games/type-away")
    @ResponseStatus(HttpStatus.CREATED)
    public GamePlayDTO awayTeamMatch(@RequestBody TeamChoiceDTO choiceDTO) {
        Long gameId = teamService.makeAwayGame(choiceDTO);
        Game game = gameService.choiceGame(gameId);

        TeamDTO homeTeam = DTOConverter.teamToDTO(game.getHome());
        TeamDTO awayTeam = DTOConverter.teamToDTO(game.getAway());

        return new GamePlayDTO(gameId, awayTeam, homeTeam);
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
        List<ScoreBoard> scoreBoard = gameService.findScoreBoardByGameId(gameId);
        String userTeamName = gameService.findUserTeamNameByGameId(gameId);

        TeamScoreDTO teamScoreDTO = DTOConverter.scoreToTeamScoreDTO(scoreBoard.get(0));
        TeamScoreDTO teamScoreDTO1 = DTOConverter.scoreToTeamScoreDTO(scoreBoard.get(1));

        if (teamScoreDTO.getTeamName().equals(userTeamName)) {
            return new GameScoreDTO(teamScoreDTO, teamScoreDTO1);
        }
        return new GameScoreDTO(teamScoreDTO1, teamScoreDTO);
    }
}
