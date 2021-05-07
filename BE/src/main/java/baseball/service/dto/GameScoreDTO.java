package baseball.service.dto;

import baseball.domain.Team;

import java.util.ArrayList;
import java.util.List;

public class GameScoreDTO {

    private Long gameId;
    private List<TeamScoreDTO> teamScores;

    public GameScoreDTO(Long gameId, Team homeTeam, Team awayTeam) {
        this.gameId = gameId;
        this.teamScores = convertToTeamScoreDTOList(homeTeam, awayTeam);
    }

    private List<TeamScoreDTO> convertToTeamScoreDTOList(Team homeTeam, Team awayTeam) {
        List<TeamScoreDTO> teamScoreDTOS = new ArrayList<>();

        TeamScoreDTO homeTeamScoreDTO = new TeamScoreDTO(homeTeam.getId(), homeTeam.getName(), homeTeam.getScores());
        TeamScoreDTO awayTeamScoreDTO = new TeamScoreDTO(awayTeam.getId(), awayTeam.getName(), awayTeam.getScores());
        teamScoreDTOS.add(homeTeamScoreDTO);
        teamScoreDTOS.add(awayTeamScoreDTO);

        return teamScoreDTOS;
    }

    public Long getGameId() {
        return gameId;
    }

    public List<TeamScoreDTO> getTeamScores() {
        return teamScores;
    }
}
