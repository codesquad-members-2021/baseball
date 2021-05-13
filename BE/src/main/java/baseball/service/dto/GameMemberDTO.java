package baseball.service.dto;

import java.util.Set;

public class GameMemberDTO {

    private Long gameId;
    private Set<RecordDTO> home;
    private Set<RecordDTO> away;

    public GameMemberDTO(Long gameId, Set<RecordDTO> home, Set<RecordDTO> away) {
        this.gameId = gameId;
        this.home = home;
        this.away = away;
    }

    public Long getGameId() {
        return gameId;
    }

    public Set<RecordDTO> getHome() {
        return home;
    }

    public Set<RecordDTO> getAway() {
        return away;
    }
}
