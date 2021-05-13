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

        setMyTeamIsUserTrue(match);
        initializeTeamScore(match);
        Team offenseTeam = findFirstOffenseTeam(match);
        reset(offenseTeam);
        Team defenseTeam = findFirstDefenseTeam(match);
        reset(defenseTeam);
        setOffenseTeamDefaultScore(offenseTeam);

        Player firstHitter = offenseTeam.getFirstHitter();
        Player pitcher = defenseTeam.getPitcher();
        return createApiResponse(match, offenseTeam, firstHitter, pitcher);
    }

    private void reset(Team team) {
        for (Player player : team.getPlayerList()) {
            player.getPlayerGameInfo().reset();
        }
    }

    public ApiResponse createApiResponse(Match match, Team offenseTeam, Player hitter, Player pitcher) {
        return new ApiResponse(match.getId(), match.getCurrentInning(),
                new PlayerLogDTO(hitter, offenseTeam.getId()), new TeamDTO(findExpeditionTeam(match)), new TeamDTO(findHomeTeam(match)),
                new PlayerDTO("투수", pitcher), new PlayerDTO("타자", hitter), new TeamLogDTO(offenseTeam, hitter));
    }

    private void setMyTeamIsUserTrue(Match match) {
        Team myTeam = findTeam(match.getMyTeamId());
        myTeam.setUser(true);
        saveTeam(myTeam);
    }

    private void initializeTeamScore(Match match) {
        saveTeam(findExpeditionTeam(match).initializeTotalScore());
        saveTeam(findHomeTeam(match).initializeTotalScore());
    }

    private void setOffenseTeamDefaultScore(Team offenseTeam) {
        offenseTeam.addDefaultScore(1);
        saveTeam(offenseTeam);
    }

    private Team findHomeTeam(Match match) {
        return findTeam(match.getHomeTeamId());
    }

    private Team findExpeditionTeam(Match match) {
        return findTeam(match.getExpeditionTeamId());
    }

    private Team findFirstOffenseTeam(Match match) {
        if (match.isHome()) {
            return findTeam(match.getExpeditionTeamId());
        }
        return findTeam(match.getHomeTeamId());
    }

    private Team findFirstDefenseTeam(Match match) {
        if (match.isHome()) {
            return findTeam(match.getHomeTeamId());
        }
        return findTeam(match.getExpeditionTeamId());
    }

    public PlayerListPopUpDTO[] getPlayerInfo(Long matchId) {
        Match match = findMatch(matchId);
        Team myTeam = findTeam(match.getMyTeamId());
        Team counterTeam = findTeam(match.getCounterTeamId());
        PlayerListPopUpDTO expeditionTeamPlayerList = new PlayerListPopUpDTO(myTeam);
        PlayerListPopUpDTO homeTeamPlayerList = new PlayerListPopUpDTO(counterTeam);
        return new PlayerListPopUpDTO[]{expeditionTeamPlayerList, homeTeamPlayerList};
    }

    public TeamGameScoreDTO[] getTeamGameScores(Long matchId) {
        Match match = findMatch(matchId);
        Team homeTeam = findHomeTeam(match);
        Team expeditionTeam = findExpeditionTeam(match);
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
        return saveMatch(new Match(myTeamId, counterTeamId, inning, isHome));
    }

    public ApiResponse exchangePlayer(Long matchId, PlayerLogDTO playerLog) {
        Match match = findMatch(matchId);
        Inning currentInning = match.getCurrentInning();

        Team offenseTeam = updateOffenseTeam(playerLog, currentInning.getInningNumber());
        Long offenseTeamId = offenseTeam.getId();

        Long defenseTeamId = match.getOtherTeamId(offenseTeamId);
        Team defenseTeam = findTeam(defenseTeamId);
        Player pitcher = updatePitcher(defenseTeam, playerLog);

        currentInning.updateOut(playerLog.isLastActionOut());
        saveMatch(match);

        Player nextHitter = offenseTeam.getNextPlayer(playerLog.getPlayerBattingOrder());

        if (currentInning.needChange()) {
            currentInning = currentInning.changeInning();
            saveMatch(match);
            clearHistoryAndSave(offenseTeam);

            defenseTeam = findTeam(offenseTeamId);
            pitcher = defenseTeam.getPitcher();

            offenseTeam = findTeam(defenseTeamId);
            nextHitter = offenseTeam.getFirstHitter();
            offenseTeam.createTotalScore(currentInning.getInningNumber());
            saveTeam(offenseTeam);
        }

        return createApiResponse(match, offenseTeam, nextHitter, pitcher);
    }

    private Player updatePitcher(Team defenseTeam, PlayerLogDTO playerLog) {
        Player pitcher = defenseTeam.getPitcher();
        pitcher.addPitchCount(playerLog.getHistoryList().size() + 1);
        return saveTeam(defenseTeam).getPitcher();
    }

    public Team updateOffenseTeam(PlayerLogDTO playerLog, int inningNumber) {
        Team offenseTeam = findOffenseTeam(playerLog);
        Player hitter = offenseTeam.findPlayerByName(playerLog.getPlayerName());
        hitter.addHistory(playerLog.getHistoryList());
        hitter.updatePlayerGameInfo(playerLog.getLastAction());
        offenseTeam.setTotalScore(inningNumber, playerLog.getTotalTeamScore());
        return saveTeam(offenseTeam);
    }

    private Team findOffenseTeam(PlayerLogDTO playerLog) {
        Long offenseTeamId = playerLog.getTeamId();
        return findTeam(offenseTeamId);
    }

    public void clearHistoryAndSave(Team offenseTeam) {
        offenseTeam.clearAllHistory();
        saveTeam(offenseTeam);
    }
}
