package com.team22.baseball.dto.response.TeamSelect;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamListDto {

    @JsonProperty("team_info")
    private TeamInfoDto teamInfoDto;

    @JsonProperty("player")
    private List<PlayerInfoDto> playerInfoDtoList;

    public TeamListDto(TeamInfoDto teamInfoDto, List<PlayerInfoDto> playerInfoDtoList) {
        this.teamInfoDto = teamInfoDto;
        this.playerInfoDtoList = playerInfoDtoList;
    }

    public TeamInfoDto getTeamInfoDto() {
        return teamInfoDto;
    }

    public void setTeamInfoDto(TeamInfoDto teamInfoDto) {
        this.teamInfoDto = teamInfoDto;
    }

    public List<PlayerInfoDto> getPlayerInfoDtoList() {
        return playerInfoDtoList;
    }

    public void setPlayerInfoDtoList(List<PlayerInfoDto> playerInfoDtoList) {
        this.playerInfoDtoList = playerInfoDtoList;
    }

    @Override
    public String toString() {
        return "TeamListDto{" +
                "teamInfoDto=" + teamInfoDto +
                ", playerInfoDtoList=" + playerInfoDtoList +
                '}';
    }
}
