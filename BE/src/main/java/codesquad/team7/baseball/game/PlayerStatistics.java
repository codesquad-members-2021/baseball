package codesquad.team7.baseball.game;

public class PlayerStatistics {

    private Integer atBat;
    private Integer hits;
    private Integer out;
    private Double average;

    PlayerStatistics(Integer atBat, Integer hits, Integer out, Double average) {
        this.atBat = atBat;
        this.hits = hits;
        this.out = out;
        this.average = average;
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

    public static PlayerStatistics newPlayerStatistics() {
        return new PlayerStatistics(
                0, 0, 0, 0.0
        );
    }
}
