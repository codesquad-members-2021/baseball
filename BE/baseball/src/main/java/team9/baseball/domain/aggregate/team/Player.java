package team9.baseball.domain.aggregate.team;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Player {
    @Id
    private Integer id;

    private String name;

    private Integer uniformNumber;

    public Player(String name, Integer uniformNumber) {
        this.name = name;
        this.uniformNumber = uniformNumber;
    }
}
