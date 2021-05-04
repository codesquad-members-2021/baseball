package codesquad.baseball.DTO;

import codesquad.baseball.domain.Player;
import codesquad.baseball.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class TeamHistoryDTO {
    public List<PlayerHistoryDTO> playerPlayerHistoryDTOList = new ArrayList<>();

    public TeamHistoryDTO(Team team) {
        for(Player player : team.getPlayerList()) {
            this.playerPlayerHistoryDTOList.add(new PlayerHistoryDTO(player));
        }
    }
}
