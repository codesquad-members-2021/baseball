package codesquad.baseball.DTO;

import codesquad.baseball.domain.Player;
import codesquad.baseball.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class TeamLogDTO {
    private List<PlayerLogDTO> playerLog = new ArrayList<>();

    public TeamLogDTO(Team team, Player player) {
        int playerIndex = team.getPlayerList().indexOf(player);
        for (int i = 0; i < playerIndex; i++) {
            Player targetPlayer = team.getPlayerList().get(i);
            this.playerLog.add(new PlayerLogDTO(targetPlayer, team.getId()));
        }

    }
}
