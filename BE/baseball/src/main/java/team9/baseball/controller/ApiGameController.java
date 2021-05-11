package team9.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team9.baseball.DTO.request.CreateGameDTO;
import team9.baseball.DTO.request.JoinGameDTO;
import team9.baseball.DTO.request.PitchResultDTO;
import team9.baseball.DTO.response.ApiResult;
import team9.baseball.service.GameService;

import javax.validation.Valid;

@RestController
@RequestMapping("/game")
public class ApiGameController {
    private final GameService gameService;

    @Autowired
    public ApiGameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/list")
    public ApiResult getGameDescriptions() {
        return ApiResult.succeed(gameService.getAllGameList());
    }

    @PostMapping
    public ApiResult createGame(@RequestBody CreateGameDTO createGameDTO) {
        gameService.createNewGame(1l, createGameDTO.getAwayTeamId(), createGameDTO.getHomeTeamId());
        return ApiResult.succeed("OK");
    }

    @PostMapping("/joining")
    public ApiResult joinGame(@Valid @RequestBody JoinGameDTO joinGameDTO) {
        gameService.joinGame(1l, joinGameDTO.getGameId(), joinGameDTO.getMyVenue());
        return ApiResult.succeed("OK");
    }

    @GetMapping("/status")
    public ApiResult getCurrentGameStatus() {
        return ApiResult.succeed(gameService.getCurrentGameStatus(1l));
    }

    @PostMapping("/status/pitch-result")
    public ApiResult pitch(@RequestBody PitchResultDTO pitchResultDTO) {
        gameService.applyPitchResult(1l, pitchResultDTO.getPitchResult());
        return ApiResult.succeed("OK");
    }

    @GetMapping("/history")
    public ApiResult getCurrentGameHistory() {
        return ApiResult.succeed(gameService.getCurrentGameHistory(1l));
    }
}
