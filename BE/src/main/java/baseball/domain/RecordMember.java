package baseball.domain;

public class RecordMember {

    private String name;
    private String position;
    private int atBat;
    private int hit;
    private int out;
    private double average;

    public RecordMember(String name, String position, int atBat, int hit, int out, double average) {
        this.name = name;
        this.position = position;
        this.atBat = atBat;
        this.hit = hit;
        this.out = out;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
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
