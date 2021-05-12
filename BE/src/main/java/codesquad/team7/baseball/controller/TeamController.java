package codesquad.team7.baseball.controller;


import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import codesquad.team7.baseball.team.TeamRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/dinos")
    public Team addDinos() {
        Team dinos = Team.newTeam("NC Dinos", 0);
        dinos.addPlayer(new Player("김준완"));
        dinos.addPlayer(new Player("박민우"));
        dinos.addPlayer(new Player("김철호"));
        dinos.addPlayer(new Player("최보성"));
        dinos.addPlayer(new Player("김민수"));
        dinos.addPlayer(new Player("김찬형"));
        dinos.addPlayer(new Player("김주원"));
        dinos.addPlayer(new Player("김기환"));
        dinos.addPlayer(new Player("최승민"));
        return teamRepository.save(dinos);
    }

    @PostMapping("/eagles")
    public Team addEagles() {
        Team eagles = Team.newTeam("Eagles", 2);
        eagles.addPlayer(new Player("조현진"));
        eagles.addPlayer(new Player("노태형"));
        eagles.addPlayer(new Player("강재민"));
        eagles.addPlayer(new Player("조한민"));
        eagles.addPlayer(new Player("김현민"));
        eagles.addPlayer(new Player("오선진"));
        eagles.addPlayer(new Player("강경학"));
        eagles.addPlayer(new Player("노시환"));
        eagles.addPlayer(new Player("박정현"));
        return teamRepository.save(eagles);
    }

}
