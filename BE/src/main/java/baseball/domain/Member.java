package baseball.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

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

    public void setRecord(Record record) {
        this.record = record;
    }

    public boolean hasRecord() {
        return record != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(name, member.name)
                && Objects.equals(position, member.position) && Objects.equals(record, member.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, record);
    }
}
