package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;

public class HomePlayerStatistics extends PlayerStatistics {

    HomePlayerStatistics(String name, Integer atBat, Integer hits, Integer out) {
        super(name, atBat, hits, out);
    }

    public static HomePlayerStatistics newInstance(Player player) {
        return new HomePlayerStatistics(
                player.getName(),
                0,0,0
        );
    }
}
