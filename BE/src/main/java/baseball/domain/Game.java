package baseball.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

public class Game implements Persistable<Long> {

    @Id
    private Long id;

    private Long homeTeamId;
    private Long awayTeamId;

    @Transient
    private boolean isNew = false;

    public Game(Long id, Long homeTeamId, Long awayTeamId) {
        this.id = id;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        isNew = true;
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

    @Override
    public boolean isNew() {
        return isNew;
    }
}
