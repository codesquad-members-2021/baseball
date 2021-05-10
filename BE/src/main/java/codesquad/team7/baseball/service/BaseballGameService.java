package codesquad.team7.baseball.service;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.repository.BaseballGameRepository;
import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.team.TeamRepository;
import codesquad.team7.baseball.view.BaseballGameTitle;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;
    private final TeamRepository teamRepository;

    public BaseballGameService(BaseballGameRepository baseballGameRepository, TeamRepository teamRepository) {
        this.baseballGameRepository = baseballGameRepository;
        this.teamRepository = teamRepository;

        initGame();
    }

    private void initGame() {
        Team dinos = Team.newTeam("NC Dinos", 0);
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

        Team eagles = Team.newTeam("Eagles", 2);
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

        BaseballGame newBaseballGame = BaseballGame.newGame(dinos, eagles);
        baseballGameRepository.save(newBaseballGame);
        baseballGameRepository.save(newBaseballGame);
        baseballGameRepository.save(newBaseballGame);
    }

    public BaseballGames baseballGames() {
        List<BaseballGame> baseballGames = baseballGameRepository.findAll();

        List<BaseballGameTitle> baseballGameTitleList = new ArrayList<>();
        for (BaseballGame baseballGame : baseballGames) {
            baseballGameTitleList.add(BaseballGameTitle.of(baseballGame));
        }

        return BaseballGames.of(baseballGameTitleList);
    }

    public BaseballGame baseballGame(Long gameId) {
        return baseballGameRepository.findById(gameId).orElseThrow(RuntimeException::new);
    }

}
