package baseball.domain;

import org.springframework.data.annotation.Id;

public class Game {

    @Id
    private Long id;

    private Long homeTeamId;
    private Long awayTeamId;

    public Game(Long homeTeamId, Long awayTeamId) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
    }

    public Long getId() {
        return id;
    }

    public Long getHomeTeamId() {
        return homeTeamId;
    }

    public Long getAwayTeamId() {
        return awayTeamId;
    }

    public boolean isTeamInGame(Team team) {
        return team.getId() == homeTeamId || team.getId() == awayTeamId;
    }
}
