package com.team22.baseball.dto.response.PlayerScoreList;

public class TeamDto {

    private String teamName;

    private boolean isHome;

    private boolean isSelected;

    public TeamDto(String teamName, boolean isHome, boolean isSelected) {
        this.teamName = teamName;
        this.isHome = isHome;
        this.isSelected = isSelected;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isHome() {
        return isHome;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public static TeamDto of(String teamName, boolean isHome, boolean isSelected) {
        return new TeamDto(teamName, isHome, isSelected);
    }
}
