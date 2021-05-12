package baseball.service.dto;

import baseball.domain.Member;
import baseball.domain.Team;

import java.util.Set;

public class TeamRequest {

    private String name;
    private Set<Member> members;

    public TeamRequest(String name, Set<Member> members) {
        this.name = name;
        this.members = members;
    }

    public Team toTeam() {
        return new Team(this.name, this.members);
    }
}
