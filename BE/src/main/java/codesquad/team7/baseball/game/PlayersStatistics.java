package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;
import codesquad.team7.baseball.team.Team;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.ArrayList;
import java.util.List;

public class PlayersStatistics {

    @MappedCollection(idColumn = "information_id", keyColumn = "player_statistics_index")
    private final List<PlayerStatistics> players;

    PlayersStatistics(List<PlayerStatistics> players) {
        this.players = players;
    }

    public static PlayersStatistics newStatistics(Team team) {
        List<PlayerStatistics> playerStatisticsList = new ArrayList<>();

        for (Player player : team.getPlayers()) {
            playerStatisticsList.add(PlayerStatistics.newPlayerStatistics(player));
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
        return players.size();
    }

    public List<PlayerStatistics> getPlayers() {
        return players;
    }
}
