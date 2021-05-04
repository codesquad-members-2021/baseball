package codesquad.baseball.DTO;

import codesquad.baseball.domain.History;
import codesquad.baseball.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlayerHistoryDTO {
    private int playerBattingOrder;
    private String playerName;
    private List<History> historyList;

    public PlayerHistoryDTO(Player player) {
        this.playerBattingOrder = player.getPlayerGameInfo().getBattingOrder();
        this.playerName = player.getName();
        this.historyList = player.getHistoryList();
    }
}
