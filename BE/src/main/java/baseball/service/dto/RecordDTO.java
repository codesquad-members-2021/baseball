package baseball.service.dto;

import baseball.domain.Member;
import baseball.domain.Record;

public class RecordDTO {

    private Long id;
    private String name;
    private String position;
    private int atBat;
    private int hit;
    private int out;

    public RecordDTO(Long id, String name, String position, int atBat, int hit, int out) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.atBat = atBat;
        this.hit = hit;
        this.out = out;
    }

    public static RecordDTO toRecordDTO(Member member, Record record) {
        return new RecordDTO(member.getId(), member.getName(), member.getPosition(),
                record.getAtBat(), record.getHit(), record.getOut());
    }

    public Long getId() {
        return id;
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
}
