package codesquad.team7.baseball.game;

import java.util.Arrays;
import java.util.List;

public class PlayersStatistics {

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
