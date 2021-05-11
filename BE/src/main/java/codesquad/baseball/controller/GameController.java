package codesquad.baseball.controller;

import codesquad.baseball.ApiResponse;
import codesquad.baseball.DTO.*;
import codesquad.baseball.domain.Inning;
import codesquad.baseball.domain.Match;
import codesquad.baseball.domain.Player;
import codesquad.baseball.domain.Team;
import codesquad.baseball.exception.TeamNotFoundException;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/game")
public class GameController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public GameController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> initialize(@RequestBody HashMap<String, String> teamInfo) {
        Long myTeamId = Long.valueOf(teamInfo.get("myTeamId"));
        Long counterTeamId = Long.valueOf(teamInfo.get("counterTeamId"));
        boolean isHome = Boolean.parseBoolean(teamInfo.get("isHome"));
        Inning inning = Inning.initiateInning(isHome);
        Match match = new Match(myTeamId, counterTeamId, inning, isHome);

        Long matchId = matchRepository.save(match).getId();

        Team homeTeam = teamRepository.findById(match.getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
        Team expeditionTeam = teamRepository.findById(match.getExpeditionTeamId()).orElseThrow(TeamNotFoundException::new);
        Team myTeam = teamRepository.findById(match.getMyTeamId()).orElseThrow(TeamNotFoundException::new);
        myTeam.setUser(true);
        teamRepository.save(myTeam);

        Team offenseTeam = isHome ? expeditionTeam : homeTeam;
        offenseTeam.initializeTotalScore(1);
        teamRepository.save(offenseTeam);

        Player firstHitter = isHome ? expeditionTeam.getFirstHitter() : homeTeam.getFirstHitter();
        Player pitcher = isHome ? homeTeam.getPitcher() : expeditionTeam.getPitcher();

        ApiResponse apiResponse = new ApiResponse(matchId, match.getCurrentInning(),
                new PlayerLogDTO(firstHitter, homeTeam.getId()), new TeamDTO(expeditionTeam), new TeamDTO(homeTeam),
                new PlayerDTO("투수", pitcher), new PlayerDTO("타자", firstHitter), new TeamLogDTO(homeTeam, firstHitter));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/{matchId}/exchange")
    public ResponseEntity<ApiResponse> exchange(@PathVariable Long matchId, @RequestBody PlayerLogDTO playerLog) {
        Match match = matchRepository.findById(matchId).orElseThrow(RuntimeException::new);
        Inning currentInning = match.getCurrentInning();

        Long offenseTeamId = playerLog.getTeamId();
        Team offenseTeam = teamRepository.findById(offenseTeamId).orElseThrow(RuntimeException::new);
        Player hitter = offenseTeam.findPlayerByName(playerLog.getPlayerName());
        hitter.addHistory(playerLog.getHistoryList());
        hitter.updatePlayerGameInfo(playerLog.getLastAction());
        offenseTeam.setTotalScore(currentInning.getInningNumber(), playerLog.getTotalTeamScore());
        teamRepository.save(offenseTeam);

        Long defenseTeamId = match.getOtherTeamId(offenseTeamId);
        Team defenseTeam = teamRepository.findById(defenseTeamId).orElseThrow(RuntimeException::new);
        Player pitcher = defenseTeam.getPitcher();
        pitcher.addPitchCount(playerLog.getHistoryList().size() + 1);
        teamRepository.save(defenseTeam);

        currentInning.updateOut(playerLog.isLastActionOut());

        Player nextHitter = offenseTeam.getNextPlayer(playerLog.getPlayerBattingOrder());

        if (currentInning.needChange()) {
            currentInning = currentInning.changeInning();
            offenseTeam.clearAllHistory();
            teamRepository.save(offenseTeam);

            offenseTeam = teamRepository.findById(defenseTeamId).orElseThrow(RuntimeException::new);
            defenseTeam = teamRepository.findById(offenseTeamId).orElseThrow(RuntimeException::new);
            nextHitter = offenseTeam.getFirstHitter();
            pitcher = defenseTeam.getPitcher();
            offenseTeam.addTotalScore(currentInning.getInningNumber());
            teamRepository.save(offenseTeam);
        }

        TeamLogDTO teamLogDTO = new TeamLogDTO(offenseTeam, nextHitter);
        matchRepository.save(match);
        Team homeTeam = teamRepository.findById(match.getHomeTeamId()).orElseThrow(TeamNotFoundException::new);
        Team expeditionTeam = teamRepository.findById(match.getExpeditionTeamId()).orElseThrow(TeamNotFoundException::new);

        ApiResponse apiResponse = new ApiResponse(matchId, currentInning, new PlayerLogDTO(nextHitter, offenseTeamId),
                new TeamDTO(expeditionTeam), new TeamDTO(homeTeam), new PlayerDTO("투수", pitcher), new PlayerDTO("타자", nextHitter), teamLogDTO);
        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/{matchId}/playerListPopUp")
    public ResponseEntity<PlayerListPopUpDTO[]> showPlayerList(@PathVariable Long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(RuntimeException::new);
        Team myTeam = teamRepository.findById(match.getMyTeamId()).orElseThrow(RuntimeException::new);
        Team counterTeam = teamRepository.findById(match.getCounterTeamId()).orElseThrow(RuntimeException::new);
        PlayerListPopUpDTO LeftTeamPlayerList = new PlayerListPopUpDTO(myTeam);
        PlayerListPopUpDTO rightTeamPlayerList = new PlayerListPopUpDTO(counterTeam);
        return new ResponseEntity<>(new PlayerListPopUpDTO[]{LeftTeamPlayerList, rightTeamPlayerList}, HttpStatus.OK);
    }

    @GetMapping("/{matchId}/detailScore")
    public ResponseEntity<TeamGameScoreDTO[]> showDetailScoreList(@PathVariable Long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(RuntimeException::new);
        Team myTeam = teamRepository.findById(match.getMyTeamId()).orElseThrow(RuntimeException::new);
        Team counterTeam = teamRepository.findById(match.getCounterTeamId()).orElseThrow(RuntimeException::new);
        TeamGameScoreDTO leftTeamScore = new TeamGameScoreDTO(myTeam);
        TeamGameScoreDTO rightTeamScore = new TeamGameScoreDTO(counterTeam);
        return new ResponseEntity<>(new TeamGameScoreDTO[]{leftTeamScore, rightTeamScore}, HttpStatus.OK);
    }
}
