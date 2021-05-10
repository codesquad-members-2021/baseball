package codesquad.team7.baseball.game;

import codesquad.team7.baseball.team.Player;
import org.springframework.data.relational.core.mapping.Column;

public class PlayerStatistics {

    @Column("player_name")
    private final String name;

    private Integer atBat;
    private Integer hits;
    private Integer out;
    private Double average;

    PlayerStatistics(String name, Integer atBat, Integer hits, Integer out, Double average) {
        this.name = name;
        this.atBat = atBat;
        this.hits = hits;
        this.out = out;
        this.average = average;
    }

    public void hit() {
        atBat++;
        hits++;
        calculateAverage();
    }

    public double calculateAverage() {
        average = hits / (double) atBat;
        return average;
    }

    public void out() {
        atBat++;
        out++;
        calculateAverage();
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

    public static PlayerStatistics newPlayerStatistics(Player player) {
        return new PlayerStatistics(
                player.getName(),
                0, 0, 0, 0.0
        );
    }
}
