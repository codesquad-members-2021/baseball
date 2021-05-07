package baseball.service;

import baseball.domain.Member;
import baseball.domain.Record;
import baseball.service.dto.RecordDTO;
import baseball.domain.Team;
import baseball.repository.TeamRepository;
import baseball.service.dto.RequestTeamDTO;
import baseball.service.dto.TeamDTO;
import baseball.service.dto.TeamRecordsDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void saveTeams(List<RequestTeamDTO> teamDTOs) {
        List<Team> teams = teamDTOs.stream()
                .map(RequestTeamDTO::toTeam)
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

    public void insertRecord(Long teamId, Long memberId, int atBat, int hit, int out) {
        Team team = teamRepository.findById(teamId).orElseThrow(NoSuchElementException::new);
        Member member = team.getMemberById(memberId);
        member.setRecord(new Record(atBat, hit, out));
        teamRepository.save(team);
    }

    public TeamRecordsDTO getRecordsOfTeam(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow(NoSuchElementException::new);
        Set<Member> members = team.getMembers();

        Set<RecordDTO> recordDTOS = new HashSet<>();
        for (Member member : members) {
            if (member.hasRecord()) {
                RecordDTO recordDTO = teamRepository.findRecordByMemberId(member.getId()).get();
                recordDTOS.add(recordDTO);
            }
        }
        return new TeamRecordsDTO(teamId, recordDTOS);
    }
}
