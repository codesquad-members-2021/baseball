package team9.baseball.domain.aggregate.team;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import team9.baseball.exception.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Player getPlayer(int uniformNumber) {
        if (!playerMap.containsKey(uniformNumber)) {
            throw new NotFoundException(this.id + "팀에 " + uniformNumber + "번호의 선수가 없습니다.");
        }
        return playerMap.get(uniformNumber);
    }

    public int getFirstPlayerUniformNumber() {
        return playerMap.keySet().stream().findFirst().
                orElseThrow(() -> new NotFoundException("팀에 속한 선수가 없습니다."));
    }

    public void addPlayer(int uniform_number, Player player) {
        playerMap.put(uniform_number, player);
    }

    public int getNextPlayerUniformNumber(int currentUniformNumber) {
        if (playerMap.size() == 0) {
            throw new NotFoundException("팀에 속한 선수가 없습니다.");
        }

        List<Integer> playerList = playerMap.keySet().stream().sorted().collect(Collectors.toList());

        int currentIndex = playerList.indexOf(currentUniformNumber);
        int nextIndex = (currentIndex + 1) % playerList.size();

        return playerList.get(nextIndex);
    }
}
