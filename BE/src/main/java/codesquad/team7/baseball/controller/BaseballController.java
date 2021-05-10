package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.service.BaseballGameService;
import codesquad.team7.baseball.view.BaseballGameView;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/1")
    public BaseballGameView baseballGame() {
        return new BaseballGameView.Builder(baseballGameService.baseballGame(1L)).bulid();
    }

    @GetMapping("/1/pitch/hit")
    public BaseballGameView hit() {
        return new BaseballGameView.Builder(baseballGameService.baseballGame(1L)).bulid();
    }

    @GetMapping("/1/pitch/ball")
    public BaseballGameView ball() {
        return new BaseballGameView.Builder(baseballGameService.baseballGame(1L)).bulid();
    }

    @GetMapping("/3/pitch/out")
    public BaseballGameView out() {
        return new BaseballGameView.Builder(baseballGameService.baseballGame(3L)).bulid();
    }

    @GetMapping("/3/pitch/strike")
    public BaseballGameView strike() {
        return new BaseballGameView.Builder(baseballGameService.baseballGame(3L)).bulid();
    }

}
