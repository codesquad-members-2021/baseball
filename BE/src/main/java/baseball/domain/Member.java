package baseball.domain;

import org.springframework.data.annotation.Id;

public class Member {

    @Id
    private Long id;

    private String name;
    private String position;

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
}
