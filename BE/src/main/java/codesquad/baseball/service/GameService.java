package codesquad.baseball.service;

import codesquad.baseball.ApiResponse;
import codesquad.baseball.DTO.*;
import codesquad.baseball.domain.Inning;
import codesquad.baseball.domain.Match;
import codesquad.baseball.domain.Player;
import codesquad.baseball.domain.Team;
import codesquad.baseball.exception.MatchNotFoundException;
import codesquad.baseball.exception.TeamNotFoundException;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class GameService {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public GameService(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    public ApiResponse getGameInfo(HashMap<String, String> teamInfo) {
        Match match = createMatch(teamInfo);

        Team myTeam = findTeam(match.getMyTeamId());
        myTeam.setUser(true);
        saveTeam(myTeam);

        Team homeTeam = findTeam(match.getHomeTeamId());
        Team expeditionTeam = findTeam(match.getExpeditionTeamId());

        Team offenseTeam = match.isHome() ? expeditionTeam : homeTeam;
        saveTeam(homeTeam.initializeTotalScore());
        saveTeam(expeditionTeam.initializeTotalScore());
        offenseTeam.addDefaultScore(1);
        saveTeam(offenseTeam);

        Player firstHitter = match.isHome() ? expeditionTeam.getFirstHitter() : homeTeam.getFirstHitter();
        Player pitcher = match.isHome() ? homeTeam.getPitcher() : expeditionTeam.getPitcher();

        return new ApiResponse(getSavedMatchId(match), match.getCurrentInning(),
                new PlayerLogDTO(firstHitter, homeTeam.getId()), new TeamDTO(expeditionTeam), new TeamDTO(homeTeam),
                new PlayerDTO("투수", pitcher), new PlayerDTO("타자", firstHitter), new TeamLogDTO(homeTeam, firstHitter));
    }

    public PlayerListPopUpDTO[] getPlayerInfo(Long matchId) {
        Match match = findMatch(matchId);
        Team myTeam = findTeam(match.getMyTeamId());
        Team counterTeam = findTeam(match.getCounterTeamId());
        PlayerListPopUpDTO LeftTeamPlayerList = new PlayerListPopUpDTO(myTeam);
        PlayerListPopUpDTO rightTeamPlayerList = new PlayerListPopUpDTO(counterTeam);
        return new PlayerListPopUpDTO[]{LeftTeamPlayerList, rightTeamPlayerList};
    }

    public TeamGameScoreDTO[] getTeamGameScores(Long matchId) {
        Match match = findMatch(matchId);
        Team homeTeam = findTeam(match.getHomeTeamId());
        Team expeditionTeam = findTeam(match.getExpeditionTeamId());
        return new TeamGameScoreDTO[]{new TeamGameScoreDTO(expeditionTeam), new TeamGameScoreDTO(homeTeam)};
    }

    public Team findTeam(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
    }

    public List<Team> findTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public Match findMatch(Long matchId) {
        return matchRepository.findById(matchId).orElseThrow(MatchNotFoundException::new);
    }

    public Long getSavedMatchId(Match match) {
        return matchRepository.save(match).getId();
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public Match createMatch(HashMap<String, String> teamInfo) {
        Long myTeamId = Long.valueOf(teamInfo.get("myTeamId"));
        Long counterTeamId = Long.valueOf(teamInfo.get("counterTeamId"));
        boolean isHome = Boolean.parseBoolean(teamInfo.get("isHome"));
        Inning inning = Inning.initiateInning(isHome);
        return new Match(myTeamId, counterTeamId, inning, isHome);
    }

    public ApiResponse exchangePlayer(Long matchId, PlayerLogDTO playerLog) {
        Match match = findMatch(matchId);
        Inning currentInning = match.getCurrentInning();

        Team offenseTeam = updateOffenseTeam(playerLog, currentInning.getInningNumber());
        Long offenseTeamId = offenseTeam.getId();

        Long defenseTeamId = match.getOtherTeamId(offenseTeamId);
        Team defenseTeam = findTeam(defenseTeamId);
        Player pitcher = defenseTeam.getPitcher();
        pitcher.addPitchCount(playerLog.getHistoryList().size() + 1);
        saveTeam(defenseTeam);

        currentInning.updateOut(playerLog.isLastActionOut());

        Player nextHitter = offenseTeam.getNextPlayer(playerLog.getPlayerBattingOrder());

        if (currentInning.needChange()) {
            currentInning = currentInning.changeInning();
            clearHistoryAndSave(offenseTeam);

            defenseTeam = findTeam(offenseTeamId);
            pitcher = defenseTeam.getPitcher();

            offenseTeam = findTeam(defenseTeamId);
            nextHitter = offenseTeam.getFirstHitter();
            offenseTeam.addTotalScore(currentInning.getInningNumber());
            saveTeam(offenseTeam);
        }

        TeamLogDTO teamLogDTO = new TeamLogDTO(offenseTeam, nextHitter);
        saveMatch(match);
        Team homeTeam = findTeam(match.getHomeTeamId());
        Team expeditionTeam = findTeam(match.getExpeditionTeamId());

        return new ApiResponse(matchId, currentInning, new PlayerLogDTO(nextHitter, offenseTeamId),
                new TeamDTO(expeditionTeam), new TeamDTO(homeTeam), new PlayerDTO("투수", pitcher), new PlayerDTO("타자", nextHitter), teamLogDTO);
    }

    public Team updateOffenseTeam(PlayerLogDTO playerLog, int inningNumber) {
        Long offenseTeamId = playerLog.getTeamId();
        Team offenseTeam = findTeam(offenseTeamId);
        Player hitter = offenseTeam.findPlayerByName(playerLog.getPlayerName());
        hitter.addHistory(playerLog.getHistoryList());
        hitter.updatePlayerGameInfo(playerLog.getLastAction());
        offenseTeam.setTotalScore(inningNumber, playerLog.getTotalTeamScore());
        return saveTeam(offenseTeam);
    }

    public void clearHistoryAndSave(Team offenseTeam) {
        offenseTeam.clearAllHistory();
        saveTeam(offenseTeam);
    }
}
