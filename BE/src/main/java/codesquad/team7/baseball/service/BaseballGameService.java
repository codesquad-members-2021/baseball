package codesquad.team7.baseball.service;

import codesquad.team7.baseball.repository.BaseballGameRepository;
import codesquad.team7.baseball.team.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;
    private final TeamRepository teamRepository;

    public BaseballGameService(BaseballGameRepository baseballGameRepository, TeamRepository teamRepository) {
        this.baseballGameRepository = baseballGameRepository;
        this.teamRepository = teamRepository;
    }

}
