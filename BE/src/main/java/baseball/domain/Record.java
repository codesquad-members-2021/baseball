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
        if (hit == 0) {
            return 0;
        }
        return atBat / (double) hit;
    }

    public int getAtBat() {
        return atBat;
    }

    public int getHit() {
        return hit;
    }

    public int getOut() {
        return out;
    }

    public double getAverage() {
        return average;
    }
}
