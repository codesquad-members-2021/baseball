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

    public String getPlayerName(int uniform_number) {
        if (!playerMap.containsKey(uniform_number)) {
            throw new NotFoundException(this.id + "팀에 " + uniform_number + "번호의 선수가 없습니다.");
        }
        return playerMap.get(uniform_number).getName();
    }

    public int getFirstPlayerUniformNumber() {
        Player firstPlayer = playerMap.values().stream().findFirst().
                orElseThrow(() -> new NotFoundException("팀에 속한 선수가 없습니다."));

        return firstPlayer.getUniformNumber();
    }

    public void addPlayer(Player player) {
        playerMap.put(player.getUniformNumber(), player);
    }

    public int getNextPlayerUniformNumber(int currentUniformNumber) {
        if (playerMap.size() == 0) {
            throw new NotFoundException("팀에 속한 선수가 없습니다.");
        }

        List<Integer> playerList = playerMap.values().stream().map(x -> x.getUniformNumber())
                .sorted().collect(Collectors.toList());

        int currentIndex = playerList.indexOf(currentUniformNumber);
        int nextIndex = (currentIndex + 1) % playerList.size();

        return playerList.get(nextIndex);
    }
}
