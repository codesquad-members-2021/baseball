package baseball.service.dto;

import baseball.domain.Game;
import baseball.domain.Team;

public class GameScoreDTO {

    private Long gameId;
    private TeamScoreDTO home;
    private TeamScoreDTO away;

    public GameScoreDTO(Game game, Team homeTeam, Team awayTeam) {
        this.gameId = game.getId();
        this.home = new TeamScoreDTO(homeTeam);
        this.away = new TeamScoreDTO(awayTeam);
    }

    public Long getGameId() {
        return gameId;
    }

    public TeamScoreDTO getHome() {
        return home;
    }

    public TeamScoreDTO getAway() {
        return away;
    }
}
