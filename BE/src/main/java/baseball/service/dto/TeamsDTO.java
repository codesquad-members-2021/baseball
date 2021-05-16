package baseball.service.dto;

import java.util.List;

public class TeamsDTO {

    private List<TeamDTO> teams;

    public TeamsDTO(List<TeamDTO> teams) {
        this.teams = teams;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }
}
