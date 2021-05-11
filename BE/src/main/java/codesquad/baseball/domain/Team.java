package codesquad.baseball.domain;

import codesquad.baseball.exception.PlayerNotFoundException;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private boolean isUser;

    @JsonIgnore
    private List<History> historyList = new ArrayList<>();

    @JsonIgnore
    private List<TeamGameScore> teamGameScoreList = new ArrayList<>();

    @JsonIgnore
    private List<Player> playerList = new ArrayList<>();

    @JsonIgnore
    public int getTotalScore() {
        int total = 0;
        for (TeamGameScore teamGameScore : teamGameScoreList) {
            total += teamGameScore.getScore();
        }
        return total;
    }

    @JsonIgnore
    public void initializeTotalScore(int inningNumber) {
        TeamGameScore teamGameScore = new TeamGameScore(inningNumber, 0);
        teamGameScoreList.clear();
        teamGameScoreList.add(teamGameScore);
    }

    @JsonIgnore
    public void addTotalScore(int inningNumber) {
        TeamGameScore teamGameScore = new TeamGameScore(inningNumber, 0);
        teamGameScoreList.add(teamGameScore);
    }

    @JsonIgnore
    public void setTotalScore(int inningNumber, int totalScore) {
        teamGameScoreList.get(inningNumber - 1).setScore(totalScore);
    }

    @JsonIgnore
    public Player getNextPlayer(int currentPlayerOrder) {
        try {
            return playerList.get(currentPlayerOrder);
        } catch (IndexOutOfBoundsException e) {
            return getFirstHitter();
        }
    }

    @JsonIgnore
    public Player getPitcher() {
        return playerList.stream()
                .filter(Player::isPitcher)
                .findFirst()
                .orElseThrow(PlayerNotFoundException::new);
    }

    @JsonIgnore
    public Player getFirstHitter() {
        return playerList.get(0);
    }

    @JsonIgnore
    public Player findPlayerByName(String name) {
        return playerList.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElseThrow(PlayerNotFoundException::new);
    }

    @JsonIgnore
    public void clearAllHistory() {
        for (Player player : playerList) {
            player.clearHistory();
            player.clearLastAction();
        }
    }
}
