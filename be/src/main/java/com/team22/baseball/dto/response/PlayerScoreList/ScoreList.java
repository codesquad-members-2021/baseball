package com.team22.baseball.dto.response.PlayerScoreList;

import java.util.List;

public class ScoreList {

    private TeamInfo teamInfo;

    private List<PlayerInfo> playerInfos;

    public ScoreList(TeamInfo teamInfo, List<PlayerInfo> playerInfos) {
        this.teamInfo = teamInfo;
        this.playerInfos = playerInfos;
    }

    public TeamInfo getTeamDto() {
        return teamInfo;
    }

    public void setTeamDto(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public List<PlayerInfo> getPlayerDtos() {
        return playerInfos;
    }

    public void setPlayerDtos(List<PlayerInfo> playerInfos) {
        this.playerInfos = playerInfos;
    }

    public static ScoreList of(TeamInfo teamInfo, List<PlayerInfo> playerInfos) {
        return new ScoreList(teamInfo, playerInfos);
    }
}
