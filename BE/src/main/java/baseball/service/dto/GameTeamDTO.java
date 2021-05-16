package baseball.service.dto;

import java.util.List;

public class GameTeamDTO {

    private Long gameId;
    private List<RecordDTO> home;
    private List<RecordDTO> away;

    public GameTeamDTO(Long gameId, List<RecordDTO> home, List<RecordDTO> away) {
        this.gameId = gameId;
        this.home = home;
        this.away = away;
    }

    public Long getGameId() {
        return gameId;
    }

    public List<RecordDTO> getHome() {
        return home;
    }

    public List<RecordDTO> getAway() {
        return away;
    }
}
