package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.service.BaseballGameService;
import codesquad.team7.baseball.view.BaseballGameView;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return new BaseballGameView.Builder(baseballGameService.baseballGame(gameId)).bulid();
    }

}
