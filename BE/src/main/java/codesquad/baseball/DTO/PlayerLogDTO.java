package codesquad.baseball.DTO;

import codesquad.baseball.domain.Constants;
import codesquad.baseball.domain.History;
import codesquad.baseball.domain.Player;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"teamId", "totalTeamScore", "playerBattingOrder", "playerName", "lastAction", "historyList"})
public class PlayerLogDTO {

    private Long teamId;
    private int totalTeamScore;
    private int playerBattingOrder;
    private String playerName;
    private String lastAction;
    private List<History> historyList;

    public PlayerLogDTO(Player player, Long teamId) {
        this.teamId = teamId;
        this.playerBattingOrder = player.getPlayerGameInfo().getBattingOrder();
        this.playerName = player.getName();
        this.lastAction = player.getLastAction();
        this.historyList = player.getHistoryList();
    }

    @JsonIgnore
    public boolean isLastActionOut() {
        return this.lastAction.equals(Constants.OUT_ACTION);
    }

    @JsonIgnore
    public boolean isLastActionHit() {
        return this.lastAction.equals(Constants.HIT_ACTION);
    }

}
