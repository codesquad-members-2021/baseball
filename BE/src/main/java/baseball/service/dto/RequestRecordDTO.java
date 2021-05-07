package baseball.service.dto;

public class RequestRecordDTO {

    private int atBat;
    private int hit;
    private int out;

    public RequestRecordDTO(int atBat, int hit, int out) {
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
}
