package team9.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team9.baseball.DTO.response.ApiResult;
import team9.baseball.domain.enums.PitchResult;
import team9.baseball.domain.enums.Venue;
import team9.baseball.service.GameService;

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
    public ApiResult createGame() {
        gameService.createNewGame(1l, 1, 2);
        return ApiResult.succeed("OK");
    }

    @PostMapping("/joining")
    public ApiResult joinGame() {
        gameService.joinGame(1l, 1, Venue.HOME);
        return ApiResult.succeed("OK");
    }

    @GetMapping("/status")
    public ApiResult getCurrentGameStatus() {
        return ApiResult.succeed(gameService.getCurrentGameStatus(1l));
    }

    @PutMapping("/status")
    public ApiResult pitch(PitchResult pitchResult) {
        gameService.applyPitchResult(1l, pitchResult);
        return ApiResult.succeed("OK");
    }
}
