package codesquad.baseball.controller;

import codesquad.baseball.ApiResponse;
import codesquad.baseball.DTO.*;
import codesquad.baseball.domain.*;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;

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
    public RedirectView initialize(@RequestBody HashMap<String, String> teamInfo) {
        Long myTeamId = Long.valueOf(teamInfo.get("myTeamId"));
        Long counterTeamId = Long.valueOf(teamInfo.get("counterTeamId"));
        boolean isHome = Boolean.parseBoolean(teamInfo.get("isHome"));
        Inning inning = new Inning(0, 1, "수비", "초");
        Match match = new Match(myTeamId, counterTeamId, inning, isHome);
        Long matchId = matchRepository.save(match).getId();
        return new RedirectView("/game/" + matchId);
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<ApiResponse> game(@PathVariable Long matchId) {
        Match match = matchRepository.findById(matchId).orElseThrow(RuntimeException::new);
        Team myTeam = teamRepository.findById(match.getMyTeamId()).orElseThrow(RuntimeException::new);
        Team counterTeam = teamRepository.findById(match.getCounterTeamId()).orElseThrow(RuntimeException::new);

        List<History> historyList = myTeam.getHistoryList();
        TeamDTO leftTeam = new TeamDTO(myTeam.getName(), 5);
        TeamDTO rightTeam = new TeamDTO(counterTeam.getName(), 5);

        TeamLogDTO teamLog = new TeamLogDTO(myTeam);
        Player player = myTeam.getPlayerList().get(0);

        PlayerDTO pitcher = new PlayerDTO("Pitcher", "Jung", 39, 1, 0);
        PlayerDTO hitter = new PlayerDTO("Hitter", "Jane", 0, 1, 0);
        //TeamLogDTO teamLog = new TeamLogDTO(myTeam);
        ApiResponse apiResponse = new ApiResponse(match.getCurrentInning(),
                new PlayerLogDTO(player, myTeam.getId()), leftTeam, rightTeam, pitcher, hitter, teamLog);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
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

    @PostMapping("/{matchId}/exchange")
    public ResponseEntity exchange(@PathVariable Long matchId, @RequestBody PlayerLogDTO history) {
        Match match = matchRepository.findById(matchId).orElseThrow(RuntimeException::new);

        //이닝 정보 얻어오기
        Inning currentInning = match.getCurrentInning();
        int playerBattingOrder = history.getPlayerBattingOrder();

        // 현재 팀의 out 가져오기
        Team currentTeam = teamRepository.findById(history.getTeamId()).orElseThrow(RuntimeException::new);
        Player nextPlayer = currentTeam.getPlayerList().get(playerBattingOrder);
        int out = nextPlayer.getHistoryList().get(0).getOut();

        // 현재 회차에 업데이트 후 저장
        currentInning.update(out);
        matchRepository.save(match);

        //기타 전체 정보 조회
        ApiResponse apiResponse = getGameInfo(match, currentInning, nextPlayer, history);
        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }

    private ApiResponse getGameInfo(Match match, Inning currentInning, Player nextPlayer, PlayerLogDTO history) {
        Team myTeam = teamRepository.findById(match.getMyTeamId()).orElseThrow(RuntimeException::new);
        Team counterTeam = teamRepository.findById(match.getCounterTeamId()).orElseThrow(RuntimeException::new);
        TeamDTO leftTeam = new TeamDTO(myTeam.getName(), 5);
        TeamDTO rightTeam = new TeamDTO(counterTeam.getName(), 5);
        PlayerDTO pitcher = new PlayerDTO("Pitcher", "Jung", 39, 1, 0);
        PlayerDTO hitter = new PlayerDTO("Hitter", "Jane", 0, 1, 0);
        TeamLogDTO teamLog = new TeamLogDTO(myTeam);
        PlayerLogDTO playerLog = new PlayerLogDTO(nextPlayer, history.getTeamId());
        return new ApiResponse(currentInning, playerLog, leftTeam, rightTeam, pitcher, hitter, teamLog);
    }

    private boolean needExchange(Inning inning) {
        return inning.getOut() == 3;
    }

}
