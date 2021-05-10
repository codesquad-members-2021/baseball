package codesquad.team7.baseball.controller;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.game.Pitch;
import codesquad.team7.baseball.repository.BaseballGameRepository;
import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.team.TeamRepository;
import codesquad.team7.baseball.view.BaseballGameTitle;
import codesquad.team7.baseball.view.BaseballGameView;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class BaseballController {

    private final BaseballGames baseballGames;
    private BaseballGame baseballGame;
    private Team dinos;
    private Team eagles;

    private final BaseballGameRepository baseballGameRepository;
    private final TeamRepository teamRepository;

    public BaseballController(BaseballGameRepository baseballGameRepository, TeamRepository teamRepository) {
        this.baseballGameRepository = baseballGameRepository;
        this.teamRepository = teamRepository;

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
        dinos = teamRepository.save(dinos);

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
        eagles = teamRepository.save(eagles);

        baseballGame = BaseballGame.newGame(dinos, eagles);
        baseballGame = baseballGameRepository.save(baseballGame);

        List<BaseballGameTitle> games = new ArrayList<>();
        games.add(BaseballGameTitle.of(baseballGame, dinos, eagles));
        baseballGames = BaseballGames.of(games);
    }

    @GetMapping
    public BaseballGames baseballGames() {
        return baseballGames;
    }

    @GetMapping("/3")
    public BaseballGameView baseballGame() {
        return new BaseballGameView.Builder(baseballGame, dinos, eagles).bulid();
    }

    @GetMapping("/3/pitch")
    public BaseballGameView pitch() {
        baseballGame.pitch(Pitch.HIT);
        return new BaseballGameView.Builder(baseballGame, dinos, eagles).bulid();
    }

}
