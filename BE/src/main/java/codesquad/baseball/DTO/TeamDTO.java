package codesquad.baseball.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import codesquad.baseball.domain.*;

@Getter
@Setter
@AllArgsConstructor
public class TeamDTO {
    private String name;
    private int totalScore;

    public TeamDTO(Team team) {
        this.name = team.getName();
        this.totalScore = team.getTotalScore();
    }//jung 실험 중
}
