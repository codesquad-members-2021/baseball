package codesquad.team7.baseball.team;

import org.springframework.data.relational.core.mapping.Column;

public class Player {

    @Column("player_name")
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
