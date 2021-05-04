package codesquad.team7.baseball.game;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Team {

    @Id
    private final Long teamId;

    private final String name;
    private final List<Player> players;
    private final Integer pitcher;

    Team(Long teamId, String name, List<Player> players, Integer pitcher) {
        this.teamId = teamId;
        this.name = name;
        this.players = players;
        this.pitcher = pitcher;
    }
}
