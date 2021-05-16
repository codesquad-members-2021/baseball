package baseball.service.dto;

import baseball.domain.Record;

public class RecordRequest {

    private int atBat;
    private int hit;
    private int out;

    public RecordRequest(int atBat, int hit, int out) {
        this.atBat = atBat;
        this.hit = hit;
        this.out = out;
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

    public Record toRecord() {
        return new Record(atBat, hit, out);
    }
}
