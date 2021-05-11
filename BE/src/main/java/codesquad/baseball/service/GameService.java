package codesquad.baseball.service;

import codesquad.baseball.ApiResponse;
import codesquad.baseball.domain.Inning;
import codesquad.baseball.domain.Match;
import codesquad.baseball.domain.Team;
import codesquad.baseball.exception.MatchNotFoundException;
import codesquad.baseball.exception.TeamNotFoundException;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GameService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public GameService(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public Match findMatch(Long matchId) {
        return matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);
    }

    public Team findTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    }

    public Match createMatch(HashMap<String, String> teamInfo) {
        Long myTeamId = Long.valueOf(teamInfo.get("myTeamId"));
        Long counterTeamId = Long.valueOf(teamInfo.get("counterTeamId"));
        boolean isHome = Boolean.parseBoolean(teamInfo.get("isHome"));
        Inning inning = Inning.initiateInning(isHome);
        return new Match(myTeamId, counterTeamId, inning, isHome);
    }

    public Long saveMatch(Match match) {
        return matchRepository.save(match).getId();
    }

    public void createApiResponse(Long matchId) {
    }
}
