package baseball.domain;

import org.springframework.data.annotation.Id;

public class Member {

    @Id
    private Long id;

    private String name;
    private String position;
    private Record record;

    public Member(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
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

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
}
