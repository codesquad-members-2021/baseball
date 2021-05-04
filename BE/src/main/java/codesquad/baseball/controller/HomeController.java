package codesquad.baseball.controller;

import codesquad.baseball.domain.Match;
import codesquad.baseball.domain.Team;
import codesquad.baseball.repository.MatchRepository;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
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
        Match match = new Match(myTeamId, counterTeamId, isHome);
        matchRepository.save(match);
        return new RedirectView("/game");
    }

    @GetMapping("/game")
    public String start() {
        return "성공";
    }

}
