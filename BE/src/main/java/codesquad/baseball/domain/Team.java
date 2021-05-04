package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    private Long id;

    private String name;

    private List<History> historyList = new ArrayList<>();

   private List<TeamGameScore> teamGameScoreList = new ArrayList<>();

   private List<Player> playerList = new ArrayList<>();

   public int getTotalScore() {
       int total=0;
       for(TeamGameScore teamGameScore: teamGameScoreList) {
           total += teamGameScore.getScore();
       }
       return total;
   }//jung 실험 중
}
