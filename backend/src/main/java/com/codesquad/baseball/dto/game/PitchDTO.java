package com.codesquad.baseball.dto.game;

import com.codesquad.baseball.dto.team.TeamDetailDTO;

public class PitchDTO {
    private PitchResultDTO pitchResult;
    private GameScoreDTO score;
    private GameStatusDTO gameStatusDTO;
    private TeamDetailDTO homeTeam;
    private TeamDetailDTO awayTeam;

    public PitchDTO(TeamDetailDTO homeTeam, TeamDetailDTO awayTeam, GameStatusDTO gameStatusDTO, GameScoreDTO score, PitchResultDTO pitchResult) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameStatusDTO = gameStatusDTO;
        this.score = score;
        this.pitchResult = pitchResult;
    }

    public TeamDetailDTO getHomeTeam() {
        return homeTeam;
    }

    public TeamDetailDTO getAwayTeam() {
        return awayTeam;
    }

    public GameStatusDTO getGameStatusDTO() {
        return gameStatusDTO;
    }

    public GameScoreDTO getScore() {
        return score;
    }

    public PitchResultDTO getPitchResult() {
        return pitchResult;
    }
}
