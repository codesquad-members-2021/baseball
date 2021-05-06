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
public class PlayerLogDTO {
    private int playerBattingOrder;
    private Long teamId;
    private String playerName;
    private List<History> historyList;

    public PlayerLogDTO(Player player, Long teamId) {
        this.teamId = teamId;
        this.playerBattingOrder = player.getPlayerGameInfo().getBattingOrder();
        this.playerName = player.getName();
        this.historyList = player.getHistoryList();
    }
}
