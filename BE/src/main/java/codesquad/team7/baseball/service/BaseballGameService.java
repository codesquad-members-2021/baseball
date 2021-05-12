package codesquad.team7.baseball.service;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.game.Pitching;
import codesquad.team7.baseball.repository.BaseballGameRepository;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.team.TeamRepository;
import codesquad.team7.baseball.view.BaseballGameTitle;
import codesquad.team7.baseball.view.BaseballGames;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;
    private final TeamRepository teamRepository;

    public BaseballGameService(BaseballGameRepository baseballGameRepository, TeamRepository teamRepository) {
        this.baseballGameRepository = baseballGameRepository;
        this.teamRepository = teamRepository;
    }

    public BaseballGames baseballGames() {
        List<BaseballGame> baseballGames = baseballGameRepository.findAllByWinnerIsNull();

        List<BaseballGameTitle> baseballGameTitleList = new ArrayList<>();
        for (BaseballGame baseballGame : baseballGames) {
            baseballGameTitleList.add(BaseballGameTitle.of(baseballGame));
        }

        return BaseballGames.of(baseballGameTitleList);
    }

    public BaseballGame baseballGame(Long gameId) {
        return baseballGameRepository.findById(gameId).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public BaseballGame pitch(Long gameId) {
        BaseballGame game = baseballGameRepository.findById(gameId).orElseThrow(RuntimeException::new);

        if (game.isGameNotFinished()) {
            game.pitch(Pitching.pitch());
            game = baseballGameRepository.save(game);
        }

        return game;
    }

    public BaseballGame newGame(Long home, Long away) {
        if (home.equals(away)) {
            throw new RuntimeException("같은 팀으로 게임을 생성할 수 없습니다.");
        }

        Team homeTeam = teamRepository.findById(home).orElseThrow(RuntimeException::new);
        Team awayTeam = teamRepository.findById(away).orElseThrow(RuntimeException::new);

        BaseballGame game = BaseballGame.newGame(homeTeam, awayTeam);

        return baseballGameRepository.save(game);
    }
}
