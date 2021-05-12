package baseball.domain;

public class Record {

    private int atBat;
    private int hit;
    private int out;
    private double average;

    public Record(int atBat, int hit, int out) {
        this.atBat = atBat;
        this.hit = hit;
        this.out = out;
        this.average = calculateAverage(atBat, hit);
    }

    private double calculateAverage(int atBat, int hit) {
        return atBat / (double) hit;
    }
}
