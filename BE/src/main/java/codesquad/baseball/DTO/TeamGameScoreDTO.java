package codesquad.baseball.DTO;

import codesquad.baseball.domain.Team;
import codesquad.baseball.domain.TeamGameScore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@JsonPropertyOrder({"teamName", "user", "teamGameScore"})
public class TeamGameScoreDTO {
    private String teamName;
    private boolean isUser;

    private List<TeamGameScore> teamGameScore;

    public TeamGameScoreDTO(Team team) {
        this.teamName = team.getName();
        this.isUser = team.isUser();
        this.teamGameScore = team.getTeamGameScoreList();
    }
}
