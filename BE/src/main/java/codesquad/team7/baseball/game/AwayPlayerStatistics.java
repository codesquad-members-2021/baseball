package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;

public class AwayPlayerStatistics extends PlayerStatistics {

    AwayPlayerStatistics(String name, Integer atBat, Integer hits, Integer out) {
        super(name, atBat, hits, out);
    }

    public static AwayPlayerStatistics newInstance(Player player) {
        return new AwayPlayerStatistics(
                player.getName(),
                0, 0, 0
        );
    }
}
