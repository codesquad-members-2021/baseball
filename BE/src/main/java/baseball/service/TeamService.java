package baseball.service;

import baseball.domain.Member;
import baseball.domain.Team;
import baseball.exception.TeamNotFoundException;
import baseball.repository.TeamRepository;
import baseball.service.dto.RecordRequest;
import baseball.service.dto.TeamDTO;
import baseball.service.dto.TeamRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    public List<TeamDTO> convertToTeamDTOList() {
        Iterable<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOs = new ArrayList<>();

        for (Team team : teams) {
            Set<Member> members = team.getMembers();
            TeamDTO teamDTO = new TeamDTO(team, members);
            teamDTOs.add(teamDTO);
        }
        return teamDTOs;
    }

    public void insertRecord(Long teamId, Long memberId, RecordRequest recordRequest) {
        Team team = teamRepository.findById(teamId).orElseThrow(TeamNotFoundException::new);
        Member member = team.getMemberById(memberId);
        member.setRecord(recordRequest.toRecord());
        teamRepository.save(team);
    }
}
