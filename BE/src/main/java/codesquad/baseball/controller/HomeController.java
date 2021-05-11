package codesquad.baseball.controller;

import codesquad.baseball.domain.*;
import codesquad.baseball.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
public class HomeController {
    private final TeamRepository teamRepository;

    public HomeController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/totalTeamList")
    public ResponseEntity<List<Team>> home() {
        List<Team> teamList = (List<Team>) teamRepository.findAll();
        return new ResponseEntity<>(teamList, HttpStatus.OK);
    }
}
