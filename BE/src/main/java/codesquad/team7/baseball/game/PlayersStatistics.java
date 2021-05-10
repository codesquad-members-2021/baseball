package codesquad.team7.baseball.game;

import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class PlayersStatistics {

    private static final int PLAYER_NUMBER = 9;

    @MappedCollection(idColumn = "information_id", keyColumn = "player_statistics_index")
    private final List<PlayerStatistics> players;

    PlayersStatistics(List<PlayerStatistics> players) {
        this.players = players;
    }

    public static PlayersStatistics newStatistics() {
        List<PlayerStatistics> playerStatisticsList = new ArrayList<>();

        for (int i = 0; i < PLAYER_NUMBER; i++) {
            playerStatisticsList.add(PlayerStatistics.newPlayerStatistics());
        }

        return new PlayersStatistics(playerStatisticsList);
    }

    public void hit(int playerNumber) {
        PlayerStatistics player = players.get(playerNumber);
        player.hit();
    }

    public void out(int playerNumber) {
        PlayerStatistics player = players.get(playerNumber);
        player.out();
    }

    public PlayerStatistics get(int i) {
        return players.get(i);
    }

    public int size() {
        return PLAYER_NUMBER;
    }
}
