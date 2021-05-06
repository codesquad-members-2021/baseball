package baseball.service.dto;

public class GameDTO {

    private Long id;

    private String homeTeamName;
    private String awayTeamName;

    public GameDTO(Long id, String homeTeamName, String awayTeamName) {
        this.id = id;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
    }

    public static GameDTO toGameDTO(Long id, String homeTeamName, String awayTeamName) {
        return new GameDTO(id, homeTeamName, awayTeamName);
    }

    public Long getId() {
        return id;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }
}
