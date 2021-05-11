package codesquad.baseball.DTO;

import codesquad.baseball.domain.History;
import codesquad.baseball.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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
        this.historyList = player.getHistoryList();
    }
}
