package codesquad.baseball.controller;

import codesquad.baseball.ApiResponse;
import codesquad.baseball.DTO.*;
import codesquad.baseball.domain.*;
import codesquad.baseball.repository.HistoryRepository;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.List;

@RestController
public class HomeController {
    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public HomeController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public ResponseEntity home() {
        List<Team> teamList = (List<Team>) teamRepository.findAll();
        return new ResponseEntity(teamList, HttpStatus.OK);
    }

    @PostMapping
    public RedirectView home(@RequestBody HashMap<String, String> teamInfo) {
        Long myTeamId = Long.valueOf(teamInfo.get("myTeamId"));
        Long counterTeamId = Long.valueOf(teamInfo.get("counterTeamId"));
        boolean isHome = Boolean.parseBoolean(teamInfo.get("isHome"));
        Inning inning = new Inning(1L, 0, 1, "수비", "초");
        Match match = new Match(myTeamId, counterTeamId, inning, isHome);
        Long matchId = matchRepository.save(match).getId();
        return new RedirectView("/game/" + matchId);
    }
}
