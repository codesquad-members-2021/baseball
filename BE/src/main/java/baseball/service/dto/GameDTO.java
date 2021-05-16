package baseball.service.dto;

import baseball.domain.Game;

public class GameDTO {

    private Long id;
    private Long homeTeamId;
    private Long awayTeamId;

    public GameDTO(Long id, Long homeTeamId, Long awayTeamId) {
        this.id = id;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
    }

    public static GameDTO toGameDTO(Game game) {
        return new GameDTO(game.getId(), game.getHomeTeamId(), game.getAwayTeamId());
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
}
