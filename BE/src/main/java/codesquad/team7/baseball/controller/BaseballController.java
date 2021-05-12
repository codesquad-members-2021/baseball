package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.service.BaseballGameService;
import codesquad.team7.baseball.view.BaseballGameView;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class BaseballController {

    private final BaseballGameService baseballGameService;

    public BaseballController(BaseballGameService baseballGameService) {
        this.baseballGameService = baseballGameService;
    }

    @GetMapping
    public BaseballGames baseballGames() {
        return baseballGameService.baseballGames();
    }

    @GetMapping("/{gameId}")
    public BaseballGameView baseballGame(@PathVariable Long gameId) {
        return buildGameView(baseballGameService.baseballGame(gameId));
    }

    @GetMapping("/{gameId}/pitch")
    public BaseballGameView pitch(@PathVariable Long gameId) {
        return buildGameView(baseballGameService.pitch(gameId));
    }

    private BaseballGameView buildGameView(BaseballGame game) {
        return new BaseballGameView.Builder(game).build();
    }
}
