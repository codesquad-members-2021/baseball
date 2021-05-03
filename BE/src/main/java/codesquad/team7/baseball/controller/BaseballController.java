package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.view.BaseballGameTitle;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class BaseballController {

    private final BaseballGames baseballGames;

    public BaseballController() {
        List<BaseballGameTitle> games = new ArrayList<>();
        games.add(BaseballGameTitle.of(1L, "Marvel", "Captain"));
        games.add(BaseballGameTitle.of(2L, "Tigers", "Twins"));
        games.add(BaseballGameTitle.of(3L, "Dodgers", "Rockets"));
        games.add(BaseballGameTitle.of(4L, "Pintos", "Heros"));
        baseballGames = BaseballGames.of(games);
    }

    @GetMapping
    public BaseballGames baseballGames() {
        return baseballGames;
    }

}
