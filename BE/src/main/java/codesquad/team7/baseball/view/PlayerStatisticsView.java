package codesquad.team7.baseball.view;

import codesquad.team7.baseball.game.PlayerStatistics;
import codesquad.team7.baseball.team.Player;

public class PlayerStatisticsView {
    private final String name;
    private final Integer atBat;
    private final Integer hits;
    private final Integer out;
    private final Double average;

    private PlayerStatisticsView(String name, Integer atBat, Integer hits, Integer out, Double average) {
        this.name = name;
        this.atBat = atBat;
        this.hits = hits;
        this.out = out;
        this.average = average;
    }

    public static PlayerStatisticsView of(Player player, PlayerStatistics playerStatistics) {
        return new PlayerStatisticsView(
                player.getName(),
                playerStatistics.getAtBat(),
                playerStatistics.getHits(),
                playerStatistics.getOut(),
                playerStatistics.getAverage()
        );
    }

    public String getName() {
        return name;
    }

    public Integer getAtBat() {
        return atBat;
    }

    public Integer getHits() {
        return hits;
    }

    public Integer getOut() {
        return out;
    }

    public Double getAverage() {
        return average;
    }
}
