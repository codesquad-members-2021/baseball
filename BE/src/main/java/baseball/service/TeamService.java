package baseball.service;

import baseball.domain.Member;
import baseball.domain.Team;
import baseball.exception.TeamNotFoundException;
import baseball.repository.TeamRepository;
import baseball.service.dto.RecordRequest;
import baseball.service.dto.TeamDTO;
import baseball.service.dto.TeamRequest;
import baseball.service.dto.TeamsDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeams(List<TeamRequest> teamDTOs) {
        List<Team> teams = teamDTOs.stream()
                .map(TeamRequest::toTeam)
                .collect(Collectors.toList());
        teamRepository.saveAll(teams);
    }

    public TeamsDTO getTeamsDTO() {
        List<TeamDTO> teamDTOs = teamRepository.findAll().stream()
                .map(TeamDTO::new)
                .collect(Collectors.toList());

        return new TeamsDTO(teamDTOs);
    }

    public void insertRecord(Long teamId, Long memberId, RecordRequest recordRequest) {
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
        Member member = team.getMemberById(memberId);
        member.setRecord(recordRequest.toRecord());
        teamRepository.save(team);
    }
}
