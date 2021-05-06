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

    public TeamLogDTO(Team team) {
        for(Player player : team.getPlayerList()) {
            this.playerLog.add(new PlayerLogDTO(player, team.getId()));
        }
    }
}
