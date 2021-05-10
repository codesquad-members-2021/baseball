package codesquad.team7.baseball.service;

import codesquad.team7.baseball.game.BaseballGame;
import codesquad.team7.baseball.repository.BaseballGameRepository;
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
    }

    public BaseballGames baseballGames() {
        List<BaseballGame> baseballGames = baseballGameRepository.findAll();

        List<BaseballGameTitle> baseballGameTitleList = new ArrayList<>();
        for (BaseballGame baseballGame : baseballGames) {
            baseballGameTitleList.add(BaseballGameTitle.of(baseballGame));
        }

        return BaseballGames.of(baseballGameTitleList);
    }

}
