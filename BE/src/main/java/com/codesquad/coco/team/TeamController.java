package com.codesquad.coco.team;

import com.codesquad.coco.game.GameService;
import com.codesquad.coco.game.domain.model.Game;
import com.codesquad.coco.game.domain.model.GamePlayDTO;
import com.codesquad.coco.team.domain.DTO.MainPageTeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamChoiceDTO;
import com.codesquad.coco.team.domain.DTO.TeamDTO;
import com.codesquad.coco.team.domain.DTO.TeamPointDTO;
import com.codesquad.coco.utils.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TeamController {

    private TeamService teamService;
    private GameService gameService;

    public TeamController(TeamService teamService, GameService gameService) {
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

    @PutMapping("/games/{gameId}/points")
    @ResponseStatus(HttpStatus.OK)
    public void plusPoint(@PathVariable Long gameId, TeamPointDTO teamPointDTO) {
        gameService.plusPoint()
    }
}
