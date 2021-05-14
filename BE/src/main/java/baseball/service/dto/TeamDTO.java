package baseball.service.dto;

import baseball.domain.Member;
import baseball.domain.Team;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TeamDTO {

    private Long id;
    private String name;
    private List<MemberDTO> members;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.members = convertToMemberDTOs(team.getMembers());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    private List<MemberDTO> convertToMemberDTOs(Set<Member> members) {
        return members.stream()
                .map(MemberDTO::new)
                .collect(Collectors.toList());
    }
}
