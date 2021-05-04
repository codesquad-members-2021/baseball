package baseball.controller;

import baseball.domain.Team;
import baseball.repository.TeamRepository;
import baseball.service.dto.RequestTeamDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/teams")
    public void createTeams(@RequestBody Set<RequestTeamDTO> teamDTOS) {
        Set<Team> teams = teamDTOS.stream()
                .map(RequestTeamDTO::toTeam)
                .collect(Collectors.toSet());
        teamRepository.saveAll(teams);
    }
}
