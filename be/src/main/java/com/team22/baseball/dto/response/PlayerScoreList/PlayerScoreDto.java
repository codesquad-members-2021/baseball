package com.team22.baseball.dto.response.PlayerScoreList;

import java.util.List;

public class PlayerScoreDto {

    private TeamDto teamDto;

    private List<PlayerDto> playerDtos;

    public PlayerScoreDto(TeamDto teamDto, List<PlayerDto> playerDtos) {
        this.teamDto = teamDto;
        this.playerDtos = playerDtos;
    }

    public TeamDto getTeamDto() {
        return teamDto;
    }

    public void setTeamDto(TeamDto teamDto) {
        this.teamDto = teamDto;
    }

    public List<PlayerDto> getPlayerDtos() {
        return playerDtos;
    }

    public void setPlayerDtos(List<PlayerDto> playerDtos) {
        this.playerDtos = playerDtos;
    }

    public static PlayerScoreDto of(TeamDto teamDto, List<PlayerDto> playerDtos) {
        return new PlayerScoreDto(teamDto, playerDtos);
    }
}
