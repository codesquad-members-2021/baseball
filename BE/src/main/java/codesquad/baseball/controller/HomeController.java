package codesquad.baseball.controller;

import codesquad.baseball.domain.*;
import codesquad.baseball.repository.TeamRepository;
import codesquad.baseball.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class HomeController {
    private final GameService gameService;

    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/totalTeamList")
    public ResponseEntity<List<Team>> selectTeam() {
        List<Team> teamList = gameService.findTeams();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }
}
