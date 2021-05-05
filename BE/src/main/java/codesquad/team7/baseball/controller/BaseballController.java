package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.view.BaseballGameTitle;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class BaseballController {

    private final BaseballGames baseballGames;
    private final BaseballGame baseballGame;
    private final Team dinos;
    private final Team eagles;

    public BaseballController() {
        List<BaseballGameTitle> games = new ArrayList<>();
        games.add(BaseballGameTitle.of(1L, "Marvel", "Captain"));
        games.add(BaseballGameTitle.of(2L, "Tigers", "Twins"));
        games.add(BaseballGameTitle.of(3L, "Dinos", "Eagles"));
        games.add(BaseballGameTitle.of(4L, "Pintos", "Heros"));
        baseballGames = BaseballGames.of(games);

        dinos = Team.newTeam("NC Dinos", 0);
        dinos.addPlayer(new Player("김준완"));
        dinos.addPlayer(new Player("박민우"));
        dinos.addPlayer(new Player("김철호"));
        dinos.addPlayer(new Player("최보성"));
        dinos.addPlayer(new Player("김민수"));
        dinos.addPlayer(new Player("김찬형"));
        dinos.addPlayer(new Player("김주원"));
        dinos.addPlayer(new Player("김기환"));
        dinos.addPlayer(new Player("최승민"));

        eagles = Team.newTeam("Eagles", 2);
        eagles.addPlayer(new Player("조현진"));
        eagles.addPlayer(new Player("노태형"));
        eagles.addPlayer(new Player("강재민"));
        eagles.addPlayer(new Player("조한민"));
        eagles.addPlayer(new Player("김현민"));
        eagles.addPlayer(new Player("오선진"));
        eagles.addPlayer(new Player("강경학"));
        eagles.addPlayer(new Player("노시환"));
        eagles.addPlayer(new Player("박정현"));

        baseballGame = BaseballGame.newGame(dinos, eagles);
    }

    @GetMapping
    public BaseballGames baseballGames() {
        return baseballGames;
    }

    @GetMapping("/3")
    public BaseballGame baseballGame() {
        return baseballGame;
    }

}
