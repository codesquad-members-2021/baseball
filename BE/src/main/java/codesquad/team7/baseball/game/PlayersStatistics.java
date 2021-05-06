package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Arrays;
import java.util.List;

public class PlayersStatistics {

    @MappedCollection(idColumn = "information_id", keyColumn = "player_statistics_index")
    private List<PlayerStatistics> players;

    PlayersStatistics(List<PlayerStatistics> players) {
        this.players = players;
    }

    public List<PlayerStatistics> getPlayers() {
        return players;
    }

    public static PlayersStatistics newStatistics() {
        return new PlayersStatistics(Arrays.asList(
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics(),
                PlayerStatistics.newPlayerStatistics()
        ));
    }
}
