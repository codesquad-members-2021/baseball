package team9.baseball.domain.aggregate.team;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.exception.NotFoundException;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {
    @Id
    private Integer id;

    private String name;

    @MappedCollection(idColumn = "team_id", keyColumn = "uniform_number")
    private Map<Integer, Player> playerMap = new HashMap<>();

    public Team(String name) {
        this.name = name;
    }

    public Player getFirstPlayer() {
        return playerMap.values().stream().findFirst().orElseThrow(() -> new NotFoundException("팀에 속한 선수가 없습니다."));
    }

    public void addPlayer(Player player) {
        playerMap.put(player.getUniformNumber(), player);
    }
}
