package codesquad.team7.baseball.game;

import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;

public class PlayerStatistics {

    @Column("player_name")
    private final String name;
    private Integer atBat;
    private Integer hits;
    private Integer out;

    @Transient
    private Double average = 0.0;

    PlayerStatistics(String name, Integer atBat, Integer hits, Integer out) {
        this.name = name;
        this.atBat = atBat;
        this.hits = hits;
        this.out = out;
    }

    public void hit() {
        atBat++;
        hits++;
        calculateAverage();
    }

    public void calculateAverage() {
        if (atBat != 0) {
            average = 0.0;
        }
        average = hits / (double) atBat;
    }

    public void out() {
        atBat++;
        out++;
        calculateAverage();
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
