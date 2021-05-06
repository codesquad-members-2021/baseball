package baseball.service.dto;

import baseball.domain.Team;

import java.util.List;

public class TeamDTO {

    private Long id;
    private String name;
    private List<MemberDTO> members;

    public TeamDTO(Team team, List<MemberDTO> members) {
        this.id = team.getId();
        this.name = team.getName();
        this.members = members;
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
}
