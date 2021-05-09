package team9.baseball.domain.aggregate.team;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Player {
    @Id
    private Integer id;

    private Integer teamId;

    private Integer uniformNumber;

    private String name;

    public Player(String name) {
        this.name = name;
    }
}
